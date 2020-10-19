package ua.edu.chdtu.deanoffice.mobile.backend.general.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import ua.edu.chdtu.deanoffice.mobile.backend.general.mapper.type.ListParameterizedType;

public class Mapper {
    private static final MatchingStrategy STRICT_MATCHING_STRATEGY = MatchingStrategies.STRICT;
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> List<T> map(List source, Class<T> destination) {
        return modelMapper.map(source, new ListParameterizedType(destination));
    }

    public static <T> T map(Object source, Class<T> destination) {
        return modelMapper.map(source, destination);
    }
}
