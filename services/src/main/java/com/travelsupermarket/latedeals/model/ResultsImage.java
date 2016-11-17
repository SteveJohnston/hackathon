package com.travelsupermarket.latedeals.model;

import com.google.common.base.Objects;

import java.util.List;
import java.util.Map;

/**
 * An image to be displayed by the results endpoint.
 */
public class ResultsImage {
    private final String id;
    private final Image.Dimensions dimensionPixels;
    private final List<ProviderImageDetails> sourceProviders;

    /**
     * Needed for Jackson
     */
    public ResultsImage() {
        this.id = null;
        this.dimensionPixels = null;
        this.sourceProviders = null;
    }

    /**
     * @param id
     * @param dimensionPixels
     * @param sourceProviders
     */
    public ResultsImage(String id, Image.Dimensions dimensionPixels, List<ProviderImageDetails> sourceProviders) {
        this.id = id;
        this.dimensionPixels = dimensionPixels;
        this.sourceProviders = sourceProviders;
    }

    public String getId() {
        return id;
    }

    public Image.Dimensions getDimensionPixels() {
        return dimensionPixels;
    }

    public List<ProviderImageDetails> getSourceProviders() {
        return sourceProviders;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, dimensionPixels, sourceProviders);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ResultsImage)) {
            return false;
        }
        ResultsImage image = (ResultsImage) o;
        return (id == null && image.getId() ==null) || id.equals(image.getId()) &&
                Objects.equal(dimensionPixels, image.getDimensionPixels()) &&
                Objects.equal(sourceProviders, image.getSourceProviders());
    }

    /**
     * Image details as supplied by a given provider.
     */
    public static class ProviderImageDetails {
        private final String providerId;
        private final Map<String, String> altText;

        /**
         * Needed for Jackson
         */
        public ProviderImageDetails() {
            this.providerId = null;
            this.altText = null;
        }

        /**
         * @param providerId
         * @param altText
         */
        public ProviderImageDetails(String providerId, Map<String, String> altText) {
            this.providerId = providerId;
            this.altText = altText;
        }

        public String getProviderId() {
            return providerId;
        }

        public Map<String, String> getAltText() {
            return altText;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(providerId, altText);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof ProviderImageDetails)) {
                return false;
            }
            ProviderImageDetails details = (ProviderImageDetails) o;
            return providerId.equals(details.getProviderId()) &&
                    Objects.equal(altText, details.getAltText());
        }
    }
}
