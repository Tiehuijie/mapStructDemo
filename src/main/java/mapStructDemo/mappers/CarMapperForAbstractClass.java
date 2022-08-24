package mapStructDemo.mappers;

import org.mapstruct.factory.Mappers;

public abstract class CarMapperForAbstractClass {
    public static final CarMapperForAbstractClass CAR_MAPPER_FOR_ABSTRACT_CLASS = Mappers.getMapper(CarMapperForAbstractClass.class);
}
