package com.daangn.daangn.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class ProductDto {

    @AllArgsConstructor
    @Getter
    public static class Get {

        private Long productId;
        private String title;
        private String content;
        private Integer price;
    }

    @AllArgsConstructor
    @Getter
    public static class Post {

        private String title;
        private String content;
        private Integer price;

    }

    @AllArgsConstructor
    @Getter
    public static class Patch {

        private String title;
        private String content;
        private Integer price;

    }
}
