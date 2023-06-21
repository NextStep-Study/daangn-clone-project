package com.daangn.daangn.review.dto;

import com.daangn.daangn.product.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class ReviewDto {

    @AllArgsConstructor
    @Getter
    public static class Get {

        private Long id;
        //        private MemberDto reviewer;
        //        private MemberDto reviewee;
        private ProductDto.Get product;
        private String content;
        private Integer point;

    }

    @AllArgsConstructor
    @Getter
    public static class Post {

        private Long reviewerId;
        private Long revieweeId;
        private Long productId;
        private String content;
        private Integer point;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch {

        private String content;
        private Integer point;

    }
}
