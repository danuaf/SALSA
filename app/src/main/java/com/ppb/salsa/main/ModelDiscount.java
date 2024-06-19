package com.ppb.salsa.main;

public class ModelDiscount {

    int imageProduct, imageDiscountLogo;
    String tvPlaceName, tvOriginalPrice, tvDiscountPrice;

    public ModelDiscount(int imageProduct, int imageDiscountLogo, String tvPlaceName, String tvOriginalPrice, String tvDiscountPrice) {
        this.imageProduct = imageProduct;
        this.imageDiscountLogo = imageDiscountLogo;
        this.tvPlaceName = tvPlaceName;
        this.tvOriginalPrice = tvOriginalPrice;
        this.tvDiscountPrice = tvDiscountPrice;
    }

    public int getimageProduct() {
        return imageProduct;
    }

    public void setImgThumb(int imgThumb) {
        this.imageProduct = imgThumb;
    }

    public String getTvPlaceName() {
        return tvPlaceName;
    }

    public void setTvPlaceName(String tvPlaceName) {
        this.tvPlaceName = tvPlaceName;
    }

    public String getTvOriginaltPrice() {
        return tvOriginalPrice;
    }

    public void setTvOriginaltPrice(String tvOriginalPrice) {
        this.tvOriginalPrice = tvOriginalPrice;
    }

    public String getTvDiscountPrice() {
        return tvDiscountPrice;
    }

    public void settvDiscountPrice(String tvDiscountPrice) {
        this.tvDiscountPrice = tvDiscountPrice;
    }

    public int getImageDiscountLogo(){
        return imageDiscountLogo;
    }

    public void setImageDiscountLogo(int imageDiscountLogo){
        this.imageDiscountLogo = imageDiscountLogo;
    }
}