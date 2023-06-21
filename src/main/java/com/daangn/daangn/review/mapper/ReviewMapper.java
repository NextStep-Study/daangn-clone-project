package com.daangn.daangn.review.mapper;

import com.daangn.daangn.member.entity.Member;
import com.daangn.daangn.product.entity.Product;
import com.daangn.daangn.product.service.ProductService;
import com.daangn.daangn.review.dto.ReviewDto;
import com.daangn.daangn.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReviewMapper {

    @Autowired
    private ProductService productService;
    @Autowired
    private MemberService memberService;

    public abstract ReviewDto.Get entityToGetRequest(Review review);

    public abstract List<ReviewDto.Get> entityToGetRequest(List<Review> reviewList);

    @Mapping(target = "reviewer", source = "postRequest.reviewerId", qualifiedByName = "mapMember")
    @Mapping(target = "reviewee", source = "postRequest.revieweeId", qualifiedByName = "mapMember")
    @Mapping(target = "product", source = "postRequest.productId", qualifiedByName = "mapProduct")
    public abstract Review postRequestToEntity(ReviewDto.Post postRequest);

    public abstract void patchRequestToEntity(ReviewDto.Patch patchRequest, @MappingTarget Review review);

    @Named("mapMember")
    protected Member mapMember(Long memberId) {
        return memberService.findById(memberId);
    }

    @Named("mapProduct")
    protected Product mapProduct(Long productId) {
        return productService.findById(productId);
    }

}
