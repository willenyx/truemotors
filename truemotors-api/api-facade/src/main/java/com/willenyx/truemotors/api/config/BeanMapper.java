package com.willenyx.truemotors.api.config;

import com.willenyx.truemotors.api.common.user.UserCreateUpdateRequestDto;
import com.willenyx.truemotors.core.services.user.UserCreateUpdateRequest;
import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * Author: William Arustamyan
 * Date: 15/05/2018
 * Time: 2:04 PM
 */
@Component
public class BeanMapper extends ConfigurableMapper {

    private MapperFactory factory;

    private final List<Converter<?, ?>> converters;

    private final List<Mapper<?, ?>> mappers;

    @Autowired(required = false)
    public BeanMapper() {
        this(null, null);
    }

    @Autowired(required = false)
    public BeanMapper(final List<Converter<?, ?>> converters) {
        this(converters, null);
    }

    @Autowired(required = false)
    public BeanMapper(List<Converter<?, ?>> converters, List<Mapper<?, ?>> mappers) {
        super(false);
        this.converters = converters != null ? converters : Collections.emptyList();
        this.mappers = mappers != null ? mappers : Collections.emptyList();
    }

    @PostConstruct
    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void configure(MapperFactory factory) {
        this.factory = factory;

        factory.classMap(UserCreateUpdateRequest.class, UserCreateUpdateRequestDto.class).byDefault().register();

        addAllSpringBeans();
    }

    @Override
    protected void configureFactoryBuilder(final DefaultMapperFactory.Builder factoryBuilder) {
        // Nothing to configure for now
    }

    @SuppressWarnings("rawtypes")
    public void addMapper(Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType())
                .byDefault()
                .customize((Mapper) mapper)
                .register();
    }


    public void addConverter(Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }

    private void addAllSpringBeans() {
        mappers.forEach(this::addMapper);
        converters.forEach(this::addConverter);
    }
}