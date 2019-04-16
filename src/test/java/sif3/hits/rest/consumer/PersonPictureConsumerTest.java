package sif3.hits.rest.consumer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.http.HttpStatus;

import sif.dd.au30.model.*;
import sif.dd.au30.model.PersonPictureType.ParentObjectRefId;
import sif.dd.au30.model.PersonPictureType.PictureSource;
import sif3.common.ws.BulkOperationResponse;
import sif3.common.ws.CreateOperationStatus;
import sif3.common.ws.OperationStatus;
import sif3.common.ws.Response;
import sif3.hits.rest.consumer.StudentPersonalConsumerTest.StudentPersonalRefIds;
import sif3.hits.rest.consumer.category.InitialiseData;
import sif3.hits.rest.consumer.category.IntegrationTest;
import sif3.infra.rest.consumer.ConsumerLoader;

public class PersonPictureConsumerTest extends BaseTest {
    private ConsumerTest<PersonPictureType, PersonPictureCollectionType> personPictureTester = null;

    private static final String REF_ID_1 = "6c77bc0a-df8c-4aae-909c-6b104015a1ce";
    private static final String REF_ID_2 = "947a9021-57e2-44cc-b206-9c527ed7119c";

    public static class PersonPictureRefIds {
        public static final String REF_ID_1 = "1b987e8b-b29f-4137-8382-6e14b95bde2c";
        public static final String REF_ID_2 = "18444885-ffe3-415c-af96-e12d716e2744";
        public static final String REF_ID_3 = "002fec9b-e808-4032-bb32-cea050ad29dc";
        public static final String REF_ID_4 = "fd8dcb65-e160-4f9d-b8a4-2f407bd3074e";
        public static final String REF_ID_5 = "7047f648-d861-4074-abaa-e200e781ce9f";
    }

    private final String BASE64_IMAGE = "/9j/4QZoRXhpZgAATU0AKgAAAAgADAEAAAMAAAABAFAAAAEBAAMAAAABAFAAAAECAAMAAAADAAAAngEGAAMAAAABAAIAAAESAAMAAAABAAEAAAEVAAMAAAABAAMAAAEaAAUAAAABAAAApAEbAAUAAAABAAAArAEoAAMAAAABAAIAAAExAAIAAAAkAAAAtAEyAAIAAAAUAAAA2IdpAAQAAAABAAAA7AAAASQACAAIAAgACvyAAAAnEAAK/IAAACcQQWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKE1hY2ludG9zaCkAMjAxNjowMToxOSAwNzoyMDoyMwAABJAAAAcAAAAEMDIyMaABAAMAAAAB//8AAKACAAQAAAABAAAAUKADAAQAAAABAAAAUAAAAAAAAAAGAQMAAwAAAAEABgAAARoABQAAAAEAAAFyARsABQAAAAEAAAF6ASgAAwAAAAEAAgAAAgEABAAAAAEAAAGCAgIABAAAAAEAAATeAAAAAAAAAEgAAAABAAAASAAAAAH/2P/tAAxBZG9iZV9DTQAC/+4ADkFkb2JlAGSAAAAAAf/bAIQADAgICAkIDAkJDBELCgsRFQ8MDA8VGBMTFRMTGBEMDAwMDAwRDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAENCwsNDg0QDg4QFA4ODhQUDg4ODhQRDAwMDAwREQwMDAwMDBEMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwM/8AAEQgAUABQAwEiAAIRAQMRAf/dAAQABf/EAT8AAAEFAQEBAQEBAAAAAAAAAAMAAQIEBQYHCAkKCwEAAQUBAQEBAQEAAAAAAAAAAQACAwQFBgcICQoLEAABBAEDAgQCBQcGCAUDDDMBAAIRAwQhEjEFQVFhEyJxgTIGFJGhsUIjJBVSwWIzNHKC0UMHJZJT8OHxY3M1FqKygyZEk1RkRcKjdDYX0lXiZfKzhMPTdePzRieUpIW0lcTU5PSltcXV5fVWZnaGlqa2xtbm9jdHV2d3h5ent8fX5/cRAAICAQIEBAMEBQYHBwYFNQEAAhEDITESBEFRYXEiEwUygZEUobFCI8FS0fAzJGLhcoKSQ1MVY3M08SUGFqKygwcmNcLSRJNUoxdkRVU2dGXi8rOEw9N14/NGlKSFtJXE1OT0pbXF1eX1VmZ2hpamtsbW5vYnN0dXZ3eHl6e3x//aAAwDAQACEQMRAD8AKkkkukcVSSSdJSySI2i13DT89PypGi0ct/ioPvfLcfB72Pj/AHOOHH/isv3fNw8ftT4f3uGXD/jI0k6ZTsSkkkklP//QKkkkukcVflXKaRWJOrzyq+M0OtE9tVdXLf8AGj4lkxcHKYpGHuR9zLIaS4L4YQv/AAfU73wLkoT4uYyDi4DwYwduLeUlJJJLjnpEV1LbGkjR44PiqZBBg8haKpZLQLTHfVdh/wAV/iOXIZ8plkZ8EfcxSlrKMQeGUL/d9Xpec+PclCAjzGMCPFLgyAbcXzRkiSSSXVOA/wD/0SpJJLpHFTYzgLRPcQrizmktII5CvU2ixsjkfSC5L/jVyOSUoc5AGUIx9rLX6FS4oT/u+t6H4BzcAJ8tI1KUuPH/AFtPVH/ms0kklyT0KlTyiDbp2ABVm2wVtk89gqLnFxLjyV1n/FTkcglk5yYMYGPtY7/TsxlOX930vP8Ax/moGMOXiQZCXuT/AKn6MY/85ZJJJdc86//SKkkp1sNjw0d+fguinOMIynI8MYgykT0jHdxoxMpCMRcpGgPEsqaHWGeG9yrddbawQzSeT4p2tDWho0ATrgPi3xvPzk5QxyOPlgajCPp9yP72X/vHr/h/wvFy0YymBPPVykdeA/u4/wDvlJJJLGdJjZW2wQ7WNAfBVLqHVmeW9irqZzQ5padQVs/Cfjefk5xhkkcnLE1KEvV7cf3sX/eOb8Q+F4uZjKUAIZ6uMhpxn93J/wB85ySnYwseWntx8FBd/CcZxjOJuMgJRI6xk8hKJjIxkKMTRHiH/9MqtYjIaXnvoFVV+gAUthWP+M3MSxfDzGJo5pxxf4P85L/0mw/A8Iyc4Cf8lE5P8L5I/wDTZpJJLgXrlJJJJKUkkkkpr5bJaHjtoVVV+8A1OnwVBd9/xZ5iWX4eIy19mcsV/wBX+cj/AIvG8l8cwjHzhI/ysRk+vyH/AKD/AP/Z/+0OCFBob3Rvc2hvcCAzLjAAOEJJTQQEAAAAAAAPHAFaAAMbJUccAgAAAgAAADhCSU0EJQAAAAAAEM3P+n2ox74JBXB2rq8Fw044QklNBDoAAAAAAOUAAAAQAAAAAQAAAAAAC3ByaW50T3V0cHV0AAAABQAAAABQc3RTYm9vbAEAAAAASW50ZWVudW0AAAAASW50ZQAAAABDbHJtAAAAD3ByaW50U2l4dGVlbkJpdGJvb2wAAAAAC3ByaW50ZXJOYW1lVEVYVAAAAAEAAAAAAA9wcmludFByb29mU2V0dXBPYmpjAAAADABQAHIAbwBvAGYAIABTAGUAdAB1AHAAAAAAAApwcm9vZlNldHVwAAAAAQAAAABCbHRuZW51bQAAAAxidWlsdGluUHJvb2YAAAAJcHJvb2ZDTVlLADhCSU0EOwAAAAACLQAAABAAAAABAAAAAAAScHJpbnRPdXRwdXRPcHRpb25zAAAAFwAAAABDcHRuYm9vbAAAAAAAQ2xicmJvb2wAAAAAAFJnc01ib29sAAAAAABDcm5DYm9vbAAAAAAAQ250Q2Jvb2wAAAAAAExibHNib29sAAAAAABOZ3R2Ym9vbAAAAAAARW1sRGJvb2wAAAAAAEludHJib29sAAAAAABCY2tnT2JqYwAAAAEAAAAAAABSR0JDAAAAAwAAAABSZCAgZG91YkBv4AAAAAAAAAAAAEdybiBkb3ViQG/gAAAAAAAAAAAAQmwgIGRvdWJAb+AAAAAAAAAAAABCcmRUVW50RiNSbHQAAAAAAAAAAAAAAABCbGQgVW50RiNSbHQAAAAAAAAAAAAAAABSc2x0VW50RiNQeGxAUgAAAAAAAAAAAAp2ZWN0b3JEYXRhYm9vbAEAAAAAUGdQc2VudW0AAAAAUGdQcwAAAABQZ1BDAAAAAExlZnRVbnRGI1JsdAAAAAAAAAAAAAAAAFRvcCBVbnRGI1JsdAAAAAAAAAAAAAAAAFNjbCBVbnRGI1ByY0BZAAAAAAAAAAAAEGNyb3BXaGVuUHJpbnRpbmdib29sAAAAAA5jcm9wUmVjdEJvdHRvbWxvbmcAAAAAAAAADGNyb3BSZWN0TGVmdGxvbmcAAAAAAAAADWNyb3BSZWN0UmlnaHRsb25nAAAAAAAAAAtjcm9wUmVjdFRvcGxvbmcAAAAAADhCSU0D7QAAAAAAEABIAAAAAQACAEgAAAABAAI4QklNBCYAAAAAAA4AAAAAAAAAAAAAP4AAADhCSU0EDQAAAAAABAAAAB44QklNBBkAAAAAAAQAAAAeOEJJTQPzAAAAAAAJAAAAAAAAAAABADhCSU0nEAAAAAAACgABAAAAAAAAAAI4QklNA/UAAAAAAEgAL2ZmAAEAbGZmAAYAAAAAAAEAL2ZmAAEAoZmaAAYAAAAAAAEAMgAAAAEAWgAAAAYAAAAAAAEANQAAAAEALQAAAAYAAAAAAAE4QklNA/gAAAAAAHAAAP////////////////////////////8D6AAAAAD/////////////////////////////A+gAAAAA/////////////////////////////wPoAAAAAP////////////////////////////8D6AAAOEJJTQQIAAAAAAAQAAAAAQAAAkAAAAJAAAAAADhCSU0EHgAAAAAABAAAAAA4QklNBBoAAAAAA08AAAAGAAAAAAAAAAAAAABQAAAAUAAAAA0AbgBvAG4AZQAuAHAAbgBnAC4AagBwAGUAZwAAAAEAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAUAAAAFAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAQAAAAAAAG51bGwAAAACAAAABmJvdW5kc09iamMAAAABAAAAAAAAUmN0MQAAAAQAAAAAVG9wIGxvbmcAAAAAAAAAAExlZnRsb25nAAAAAAAAAABCdG9tbG9uZwAAAFAAAAAAUmdodGxvbmcAAABQAAAABnNsaWNlc1ZsTHMAAAABT2JqYwAAAAEAAAAAAAVzbGljZQAAABIAAAAHc2xpY2VJRGxvbmcAAAAAAAAAB2dyb3VwSURsb25nAAAAAAAAAAZvcmlnaW5lbnVtAAAADEVTbGljZU9yaWdpbgAAAA1hdXRvR2VuZXJhdGVkAAAAAFR5cGVlbnVtAAAACkVTbGljZVR5cGUAAAAASW1nIAAAAAZib3VuZHNPYmpjAAAAAQAAAAAAAFJjdDEAAAAEAAAAAFRvcCBsb25nAAAAAAAAAABMZWZ0bG9uZwAAAAAAAAAAQnRvbWxvbmcAAABQAAAAAFJnaHRsb25nAAAAUAAAAAN1cmxURVhUAAAAAQAAAAAAAG51bGxURVhUAAAAAQAAAAAAAE1zZ2VURVhUAAAAAQAAAAAABmFsdFRhZ1RFWFQAAAABAAAAAAAOY2VsbFRleHRJc0hUTUxib29sAQAAAAhjZWxsVGV4dFRFWFQAAAABAAAAAAAJaG9yekFsaWduZW51bQAAAA9FU2xpY2VIb3J6QWxpZ24AAAAHZGVmYXVsdAAAAAl2ZXJ0QWxpZ25l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MzI1LCAyMDE1LzA5LzEwLTAxOjEwOjIwICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1sbnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIiB4bWxuczpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1wTU06RG9jdW1lbnRJRD0iYWRvYmU6ZG9jaWQ6cGhvdG9zaG9wOjc0NTY4NTUwLWZlYzgtMTE3OC05Mzk5LWI4YmE0MDI0NjRmYyIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo5MzE5YmI3Ny1mZDczLTQ4N2EtYTkwZC1mNDUzODRhZDVhZDgiIHhtcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD0iNUJDQjc2Q0IzODBENTQ3OTM1OTE1RTBCNDcxMkVGNzkiIGRjOmZvcm1hdD0iaW1hZ2UvanBlZyIgcGhvdG9zaG9wOkNvbG9yTW9kZT0iMyIgeG1wOkNyZWF0ZURhdGU9IjIwMTYtMDEtMTlUMDc6MTk6MTkrMDg6MDAiIHhtcDpNb2RpZnlEYXRlPSIyMDE2LTAxLTE5VDA3OjIwOjIzKzA4OjAwIiB4bXA6TWV0YWRhdGFEYXRlPSIyMDE2LTAxLTE5VDA3OjIwOjIzKzA4OjAwIj4gPHhtcE1NOkhpc3Rvcnk+IDxyZGY6U2VxPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6MGViYWIyZWYtODY1MC00ZDVmLThhNDMtMGYwMjVmNTUyODNlIiBzdEV2dDp3aGVuPSIyMDE2LTAxLTE5VDA3OjIwOjIzKzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxNSAoTWFjaW50b3NoKSIgc3RFdnQ6Y2hhbmdlZD0iLyIvPiA8cmRmOmxpIHN0RXZ0OmFjdGlvbj0ic2F2ZWQiIHN0RXZ0Omluc3RhbmNlSUQ9InhtcC5paWQ6OTMxOWJiNzctZmQ3My00ODdhLWE5MGQtZjQ1Mzg0YWQ1YWQ4IiBzdEV2dDp3aGVuPSIyMDE2LTAxLTE5VDA3OjIwOjIzKzA4OjAwIiBzdEV2dDpzb2Z0d2FyZUFnZW50PSJBZG9iZSBQaG90b3Nob3AgQ0MgMjAxNSAoTWFjaW50b3NoKSIgc3RFdnQ6Y2hhbmdlZD0iLyIvPiA8L3JkZjpTZXE+IDwveG1wTU06SGlzdG9yeT4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPD94cGFja2V0IGVuZD0idyI/Pv/uAA5BZG9iZQBkgAAAAAH/2wCEAAgGBgYGBggGBggMCAcIDA4KCAgKDhANDQ4NDRARDAwMDAwMEQwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwBCQgICQoJCwkJCw4LDQsOEQ4ODg4REQwMDAwMEREMDAwMDAwRDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDP/AABEIAFAAUAMBIgACEQEDEQH/3QAEAAX/xAGiAAAABwEBAQEBAAAAAAAAAAAEBQMCBgEABwgJCgsBAAICAwEBAQEBAAAAAAAAAAEAAgMEBQYHCAkKCxAAAgEDAwIEAgYHAwQCBgJzAQIDEQQABSESMUFRBhNhInGBFDKRoQcVsUIjwVLR4TMWYvAkcoLxJUM0U5KismNzwjVEJ5OjszYXVGR0w9LiCCaDCQoYGYSURUaktFbTVSga8uPzxNTk9GV1hZWltcXV5fVmdoaWprbG1ub2N0dXZ3eHl6e3x9fn9zhIWGh4iJiouMjY6PgpOUlZaXmJmam5ydnp+So6SlpqeoqaqrrK2ur6EQACAgECAwUFBAUGBAgDA20BAAIRAwQhEjFBBVETYSIGcYGRMqGx8BTB0eEjQhVSYnLxMyQ0Q4IWklMlomOywgdz0jXiRIMXVJMICQoYGSY2RRonZHRVN/Kjs8MoKdPj84SUpLTE1OT0ZXWFlaW1xdXl9UZWZnaGlqa2xtbm9kdXZ3eHl6e3x9fn9zhIWGh4iJiouMjY6Pg5SVlpeYmZqbnJ2en5KjpKWmp6ipqqusra6vr/2gAMAwEAAhEDEQA/ABGbNmztHmnZs2brsMCuzYqttO4qqGh8aD9eW1rOvVD47UP6sxvz+j8TwvzOHxOXB4kOO+X03xN/5TU8HieBl4P53BLh/wBNSjmzdNjmzJaHZs2bCr//0BGbNmztHmnAEmg64aW1sIVqwrIep8PbAVmoada9t6fLDTOE9t+2M2Dw+ztPIw8WHiZZDaRgTwwgD3HhlxPV+y3ZuLLx63NET4JcGMHcCVXKVfGPC7NmzZ5y9ooXFssqkqKSDcHx9jhYQQSD1Gxw6wrvFCztT9qh+k56L7EdsZ8xydnaiZyeHDxMUpbyjEERlC/5vqjwvGe1PZuLEIa3DEQ45cGQDYGRHFGVd/p9ShmzZs7x5N//0RGbNmztHmkRZMFnFf2gQPnhnhKrFWDDqMNYJlnSo+0PtL4e+efe3XZeac8XaWKJlCEPCy1vwVIyhP8Aq+uUS9f7Ka/HGOTRTIjKUuPHf8VipR/relVzZs2efvYOwsvSDOaGtAAfng6eZYUJP2iPhXx7YVMxdizdTvnf+wnZmaOTL2lkiYwlA4sd7cdmMpy/qx4Y7vIe1euxmGPRQIlIS8SdfwUDGMfeeJrNmzZ6E8e//9IRmzY+GMyyKg79T7Z2OTJDHCWTIRGMAZSJ5CMdyS85CEpyjCAMpSIAA5knkFSC2aY16J3P9MMYokhBEYpXZj45aIsahFFAMdnknb3tNqu0cs8WGcsWlBIjCPpOSI/iy9/F/M+mL6H2T2Hg0cI5MkRkzkXKR34D/Nx+7+c7NmzZzjulksSTACQVoKA9wMLp7ZoTXqnY/wBcNMa6LIpRhUHOj7B9ptV2dlhizTll0pIEoS9RxxP8WLu4f5n0ul7W7DwayEsmOIx5wLjIbcZ/m5Pf/OSbNj5ozFIyHt0PiO2Mz1vHkhkhHJAiUZgSiRyMZbgvnc4ShKUJipRJBB6Ec3//0xGD7COitKRudh8sAYa2oAgSncVP05me2mqlg7IlCBo6jJHET/R3yS/03h8Lj+zOnjl7RjKQsYYSyf520I/LjVs2bNnkz6E7NmzYq7NmzYqg7+OqrKBuNj8jgDDa5AMD1Hao+eFOes+xeqln7IjCZJOnySxA/wBHbJEf5vHwvnvtNp44u0TKO3jQjkI894H58D//2Q==";

    private final String[] REF_IDS = { REF_ID_1, REF_ID_2 };

    @Test
    @Category({ IntegrationTest.class, InitialiseData.class })
    public void initialiseData() throws Exception {
        ObjectFactory objectFactory = new ObjectFactory();

        PersonPictureType personPicture = new PersonPictureType();
        personPicture.setRefId(PersonPictureRefIds.REF_ID_1);
        personPicture.setOKToPublish(objectFactory.createPersonPictureTypeOKToPublish(AUCodeSetsYesOrNoCategoryType.Y));
        ParentObjectRefId parentObjectRefId = objectFactory.createPersonPictureTypeParentObjectRefId();
        parentObjectRefId.setSIFRefObject("StudentPersonal");
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_1);
        personPicture.setParentObjectRefId(parentObjectRefId);

        PictureSource pictureSource = objectFactory.createPersonPictureTypePictureSource();
        pictureSource.setType(AUCodeSetsPictureSourceType.fromValue("01")); // url
        pictureSource.setValue("http://www.gravatar.com/avatar/HASH?d=mm");
        personPicture.setPictureSource(pictureSource);
        personPicture.setSchoolYear(getDate("2016"));

        PublishingPermissionListType publishingPermissionListType = objectFactory.createPublishingPermissionListType();
        for (int i = 0; i < 5; i++) {
            PublishingPermissionType publishingPermission = objectFactory.createPublishingPermissionType();
            publishingPermission.setPermissionValue(AUCodeSetsYesOrNoCategoryType.fromValue("Y"));
            publishingPermission.setPermissionCategory(AUCodeSetsPermissionCategoryCodeType.values()[i]);
            publishingPermissionListType.getPublishingPermission().add(publishingPermission);
        }
        personPicture.setPublishingPermissionList(objectFactory.createPersonPictureTypePublishingPermissionList(publishingPermissionListType));

        personPictureTester.doCreateOne(personPicture);
        String xmlExpectedTo = personPictureTester.getXML(personPicture);

        personPicture.setRefId(PersonPictureRefIds.REF_ID_2);
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_2);
        personPictureTester.doCreateOne(personPicture);

        personPicture.setRefId(PersonPictureRefIds.REF_ID_3);
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_3);
        personPictureTester.doCreateOne(personPicture);

        personPicture.setRefId(PersonPictureRefIds.REF_ID_4);
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_4);
        personPictureTester.doCreateOne(personPicture);

        personPicture.setRefId(PersonPictureRefIds.REF_ID_5);
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_5);
        pictureSource.setType(AUCodeSetsPictureSourceType.fromValue("02")); // hash
        pictureSource.setValue(BASE64_IMAGE);
        personPictureTester.doCreateOne(personPicture);
        String xmlExpectedToBase64 = personPictureTester.getXML(personPicture);

        PersonPictureType getResult = personPictureTester.doGetOne(PersonPictureRefIds.REF_ID_1);
        String xmlExpectedFrom = personPictureTester.getXML(getResult);
        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }

        PersonPictureType getResultBase64 = personPictureTester.doGetOne(PersonPictureRefIds.REF_ID_5);
        String xmlExpectedFromBase64 = personPictureTester.getXML(getResultBase64);
        boolean semiEqualsBase64 = semiEquals(xmlExpectedFromBase64, xmlExpectedToBase64);
        if (!semiEqualsBase64) {
            Assert.assertEquals("XML Differs", xmlExpectedFromBase64, xmlExpectedToBase64);
        }
    }

    @Before
    public void setup() {
        ConsumerLoader.initialise("TestConsumer");
        personPictureTester = new ConsumerTest<PersonPictureType, PersonPictureCollectionType>(PersonPictureType.class, "PersonPicture", PersonPictureCollectionType.class,
                "PersonPictures");
        personPictureTester.testDeleteMany(REF_IDS);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testQBE() {
        ObjectFactory objectFactory = new ObjectFactory();
        PersonPictureType personPicture = new PersonPictureType();
        ParentObjectRefId parentObjectRefId = objectFactory.createPersonPictureTypeParentObjectRefId();
        parentObjectRefId.setSIFRefObject("StudentPersonal");
        parentObjectRefId.setValue(StudentPersonalRefIds.REF_ID_1);
        personPicture.setParentObjectRefId(parentObjectRefId);
        List<Response> responses = personPictureTester.testQBE(personPicture, 1000, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        PersonPictureCollectionType personPictureCollectionType = (PersonPictureCollectionType) response.getDataObject();
        Assert.assertNotNull(personPictureCollectionType.getPersonPicture());
        Assert.assertFalse(personPictureCollectionType.getPersonPicture().isEmpty());
        boolean found = false;
        for (PersonPictureType personPictureType : personPictureCollectionType.getPersonPicture()) {
            found = found || PersonPictureRefIds.REF_ID_1.equals(personPictureType.getRefId());
            Assert.assertNotNull(personPictureType.getParentObjectRefId());
            Assert.assertEquals(StudentPersonalRefIds.REF_ID_1, personPictureType.getParentObjectRefId().getValue());
        }
        Assert.assertTrue(found);
    }

    @Test
    @Category(IntegrationTest.class)
    public void testUpdateSingle() throws Exception {
        List<Response> responses = personPictureTester.testGetSingle(PersonPictureRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonPictureType staffPersonal = (PersonPictureType) response.getDataObject();
        Assert.assertEquals(PersonPictureRefIds.REF_ID_1, staffPersonal.getRefId());

        String xmlExpectedFrom = personPictureTester.getXML(staffPersonal);

        List<Response> updateResponses = personPictureTester.doUpdateOne(staffPersonal, PersonPictureRefIds.REF_ID_1);
        Assert.assertNotNull(updateResponses);
        Assert.assertEquals(1, updateResponses.size());
        Assert.assertEquals(updateResponses.get(0).getStatus(), HttpStatus.NO_CONTENT.value());

        List<Response> getResponses = personPictureTester.testGetSingle(PersonPictureRefIds.REF_ID_1);
        Assert.assertNotNull(getResponses);
        Assert.assertEquals(1, getResponses.size());
        Response getResponse = getResponses.get(0);
        Assert.assertNotNull(getResponse.getDataObject());
        PersonPictureType comparisonTo = (PersonPictureType) getResponse.getDataObject();
        Assert.assertEquals(PersonPictureRefIds.REF_ID_1, comparisonTo.getRefId());
        String xmlExpectedTo = personPictureTester.getXML(comparisonTo);

        boolean semiEquals = semiEquals(xmlExpectedFrom, xmlExpectedTo);
        if (!semiEquals) {
            System.out.println("From:\n" + xmlExpectedFrom);
            System.out.println("\nTo:\n" + xmlExpectedTo);
            Assert.assertEquals("XML Differs", xmlExpectedFrom, xmlExpectedTo);
        }
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetSingle() {
        List<Response> responses = personPictureTester.testGetSingle(PersonPictureRefIds.REF_ID_1);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonPictureType personPicture = (PersonPictureType) response.getDataObject();
        Assert.assertEquals(PersonPictureRefIds.REF_ID_1, personPicture.getRefId());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testGetMany() {
        List<Response> responses = personPictureTester.testGetMany(5, 0);
        Assert.assertNotNull(responses);
        Assert.assertEquals(1, responses.size());
        Response response = responses.get(0);
        Assert.assertNotNull(response.getDataObject());
        PersonPictureCollectionType personPictures = (PersonPictureCollectionType) response.getDataObject();
        Assert.assertNotNull(personPictures.getPersonPicture());
        Assert.assertEquals(5, personPictures.getPersonPicture().size());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDelete() {
        List<Response> createResponses = personPictureTester.testCreateOne("personpicture.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        Response createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getDataObject());
        PersonPictureType personPicture = (PersonPictureType) createResponse.getDataObject();
        Assert.assertEquals(REF_ID_1, personPicture.getRefId());

        List<Response> deleteResponses = personPictureTester.testDeleteOne(REF_ID_1);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        Response deleteResponse = deleteResponses.get(0);
        Assert.assertNull(deleteResponse.getDataObject());
        Assert.assertEquals(HttpStatus.NO_CONTENT.value(), deleteResponse.getStatus());
    }

    @Test
    @Category(IntegrationTest.class)
    public void testCreateDeleteMany() {
        final List<String> REF_ID_LIST = Arrays.asList(REF_IDS);

        List<BulkOperationResponse<CreateOperationStatus>> createResponses = personPictureTester.testCreateMany("personpictures.xml");
        Assert.assertNotNull(createResponses);
        Assert.assertEquals(1, createResponses.size());
        BulkOperationResponse<CreateOperationStatus> createResponse = createResponses.get(0);
        Assert.assertNotNull(createResponse.getOperationStatuses());
        Assert.assertEquals(2, createResponse.getOperationStatuses().size());
        for (CreateOperationStatus operationStatus : createResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getAdvisoryID()));
            Assert.assertEquals(HttpStatus.CREATED.value(), operationStatus.getStatus());
        }

        List<BulkOperationResponse<OperationStatus>> deleteResponses = personPictureTester.testDeleteMany(REF_IDS);
        Assert.assertNotNull(deleteResponses);
        Assert.assertEquals(1, deleteResponses.size());
        BulkOperationResponse<OperationStatus> deleteResponse = deleteResponses.get(0);
        Assert.assertNotNull(deleteResponse.getOperationStatuses());
        Assert.assertEquals(2, deleteResponse.getOperationStatuses().size());
        for (OperationStatus operationStatus : deleteResponse.getOperationStatuses()) {
            Assert.assertTrue(REF_ID_LIST.contains(operationStatus.getResourceID()));
            Assert.assertEquals(HttpStatus.OK.value(), operationStatus.getStatus());
        }
    }
}
