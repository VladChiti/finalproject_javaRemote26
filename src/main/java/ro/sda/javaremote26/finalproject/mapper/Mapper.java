package ro.sda.javaremote26.finalproject.mapper;

public interface Mapper <E,D>{
    public  D mapToDto(E e);
    public  E mapToEntity(D d);
}