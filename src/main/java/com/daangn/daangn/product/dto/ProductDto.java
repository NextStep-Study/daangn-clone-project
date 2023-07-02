package com.daangn.daangn.product.dto;

import com.daangn.daangn.product.entity.Category;
import com.daangn.daangn.product.entity.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class ProductDto {

    @AllArgsConstructor
    @Getter
    public static class Get {

        private Long productId;
        private Long title;
        private String content;
        private Integer price;
        private List<PhotoDto.Get> photoList;
        private LocalDateTime refreshedAt;
        private Long refreshedCnt;
        private String status;
        private String category;
        private Long sellerId;
        private String sellerNickname;
        private Long buyerId;
        private String buyerNickname;
        private Long reviewId;
    }

    @AllArgsConstructor
    @Getter
    public static class Post {

        private String title;
        private String content;
        private Integer price;
        private List<PhotoDto.Post> photoList;
        private LocalDateTime refreshedAt = null;
        private Long refreshedCnt = 0L;
        private ProductStatus status = ProductStatus.ONSALE;
        private Category category;
        private Long sellerId;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch {

        private String title;
        private String content;
        private Integer price;
        private ProductStatus status;
        private Category category;

    }
}
