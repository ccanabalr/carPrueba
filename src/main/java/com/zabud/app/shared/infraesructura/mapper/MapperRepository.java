package com.zabud.app.shared.infraesructura.mapper;

import java.util.List;

import java.util.function.Function;
import java.util.stream.Collectors;


import org.springframework.data.domain.Page;

public interface MapperRepository<Dto, Dominio> {
 
	public Dto transformerDominioToDto(Dominio o);
	
	public Dominio transformerDtoToDominio(Dto i);
	
//	public Optional<Dto> tranformerDominioToDto(Dominio o);
//	
//	public Optional<Dominio> tranformerDtoToDominio(Dto i);
	
	public default List<Dominio> transformerListDtoToDominio(List<Dto> instances){
		return instances.stream().map(i->transformerDtoToDominio(i)).collect(Collectors.toList());
	}
	
	public default Page<Dominio>  transformerPageDtoToDominio(Page<Dto> instances){
		return instances.map(new Function<Dto, Dominio>() {

			@Override
			public Dominio apply(Dto t) {
				// TODO Auto-generated method stub
				return transformerDtoToDominio(t);
			}
		});
	}
	
	public default List<Dto> tranformerListDominioToDto(List<Dominio> instances){
		return instances.stream().map(i-> transformerDominioToDto(i)).collect(Collectors.toList());
	}
	
	public default Page<Dto> tranformerPageDominioToDto(Page<Dominio> instances){
		return instances.map(new Function<Dominio, Dto>() {
			

			@Override
			public Dto apply(Dominio t) {
				// TODO Auto-generated method stub
				return transformerDominioToDto(t);
			}
		});
	}
	
}
