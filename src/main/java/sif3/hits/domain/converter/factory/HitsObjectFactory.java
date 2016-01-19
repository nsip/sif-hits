package sif3.hits.domain.converter.factory;

/**
 * This class is defined so that we can use a custom proxy to handle nulls
 * differently to the default Object Factory.
 * 
 * If we are setting a value that is null do not call the setter.
 * 
 * @see sif3.hits.domain.converter.HitsConverter#nullValueInvocationHandler
 */
public class HitsObjectFactory extends sif.dd.au30.model.ObjectFactory implements IObjectFactory {

}
