package com.zabud.app.shared.infraesructura.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

public interface MapperApi<RestDto, Dominio> {
	
	public RestDto apiConverDominioToRestDto(Dominio o);
	public Dominio apiConvertRestDtoToDomimio(RestDto i);
	
	public default List<Dominio> apiConvertListRestDtoToDominio(List<RestDto> instances){
		return instances.stream().map(i-> apiConvertRestDtoToDomimio(i)).collect(Collectors.toList());
	}
	
	public default Page<Dominio> apiConvertPageRestDtoToDominio(Page<RestDto> instances){
		return instances.map(new Function<RestDto, Dominio>() {

			@Override
			public Dominio apply(RestDto t) {
				// TODO Auto-generated method stub
				return apiConvertRestDtoToDomimio(t);
			}
		});
	}
	
	public default List<RestDto> apiConvertListDominioToRestDto(List<Dominio> instances){
		return instances.stream().map(o -> apiConverDominioToRestDto(o)).collect(Collectors.toList());
	}
	
	public default Page<RestDto> apiConvertPageDominioToRestDto(Page<Dominio> instances){
		return instances.map(new Function<Dominio, RestDto>() {

			@Override
			public RestDto apply(Dominio t) {
				// TODO Auto-generated method stub
				return apiConverDominioToRestDto(t);
			}
		});
	}
	
}
