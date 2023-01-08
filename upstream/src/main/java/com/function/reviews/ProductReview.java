package com.function.reviews;

import java.util.ArrayList;
import java.util.List;

public class ProductReview {

    private Integer productId;
    private String review;

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getReview() {
        return this.review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public static List<ProductReview> getAllReviews() {
        var productReviews = new ArrayList<ProductReview>();

        var productReview1 = new ProductReview();
        productReview1.setProductId(1);
        productReview1.setReview("This was great!");

        var productReview2 = new ProductReview();
        productReview2.setProductId(2);
        productReview2.setReview("Poor quality...");

        productReviews.add(productReview1);
        productReviews.add(productReview2);

        return productReviews;
    }
}
