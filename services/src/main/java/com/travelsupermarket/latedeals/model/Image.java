package com.travelsupermarket.latedeals.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.Objects;

import java.util.List;
import java.util.Map;

/**
 * The hotel image info as sent to the front end.
 */
public class Image {
    private final String accomId;
    private final String channel;
    private final List<ProviderImageDetails> providers;
    private volatile Map<String, String> altText;
    private final String imageHash;
    private final Dimensions dimensionPixels;
    private final int order;

    /**
     * Needed for jackson
     */
    public Image() {
        this.accomId = null;
        this.channel = null;
        this.providers = null;
        this.imageHash = null;
        this.dimensionPixels = null;
        this.order = 0;
    }

    /**
     * @param accomId
     * @param channel
     * @param providers
     * @param imageHash
     * @param dimensionPixels
     * @param order
     */
    public Image(String accomId, String channel, List<ProviderImageDetails> providers, String imageHash, Dimensions dimensionPixels, int order) {
        this.accomId = accomId;
        this.channel = channel;
        this.providers = providers;
        this.imageHash = imageHash;
        this.dimensionPixels = dimensionPixels;
        this.order = order;
    }

    public void setAltText(Map<String, String> altText) {
        this.altText = altText;
    }

    public List<ProviderImageDetails> getProviders() {
        return providers;
    }

    public Map<String, String> getAltText() {
        return altText;
    }

    public String getImageHash() {
        return imageHash;
    }

    public Dimensions getDimensionPixels() {
        return dimensionPixels;
    }

    public int getOrder() {
        return order;
    }

    @JsonIgnore
    public String getAccomId() {
        return accomId;
    }

    @JsonIgnore
    public String getChannel() {
        return channel;
    }

    /**
     * The height and width of the image.
     */
    public static class Dimensions {
        private final int height;
        private final int width;

        /**
         * Needed for Jackson
         */
        public Dimensions() {
            this.height = 0;
            this.width = 0;
        }

        /**
         * @param height
         * @param width
         */
        public Dimensions(int height, int width) {
            this.height = height;
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(width, height);
        }

        @Override
        public boolean equals(Object o) {
            return (o instanceof Dimensions) && ((Dimensions) o).getHeight() == height && ((Dimensions) o).getWidth() == width;
        }
    }

    /**
     * Image details as supplied by a given provider.
     */
    public static class ProviderImageDetails {
        private final String id;
        private final Map<String, String> altText;

        /**
         * Needed for Jackson
         */
        public ProviderImageDetails() {
            this.id = null;
            this.altText = null;
        }

        /**
         * @param id
         * @param altText
         */
        public ProviderImageDetails(String id, Map<String, String> altText) {
            this.id = id;
            this.altText = altText;
        }

        public String getId() {
            return id;
        }

        public Map<String, String> getAltText() {
            return altText;
        }
    }
}
