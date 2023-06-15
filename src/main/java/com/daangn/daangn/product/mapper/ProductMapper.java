package com.daangn.daangn.product.mapper;

import com.daangn.daangn.product.dto.ProductDto;
import com.daangn.daangn.product.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {

    public abstract ProductDto.Get entityToGetRequest(Product product);

    public abstract Product postRequestToEntity(ProductDto.Post postRequest);

    public abstract void patchRequestToEntity(ProductDto.Patch patchRequest, @MappingTarget Product product);

}
