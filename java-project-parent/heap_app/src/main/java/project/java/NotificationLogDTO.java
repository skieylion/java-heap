package project.java;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class NotificationLogDTO {

    private final String subject;
    private final String requestNumber;
    private final List<Addressee> addresses;
    private final List<Addressee> skippedAddresses;
    private final String serviceCode;
    private final String templateCode;
    private final Date sendTime;
    private final boolean successful;
    private final boolean fillSubjectPlaceholders;
    private final Map<String, Object> model;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String subject;
        private String requestNumber;
        private List<Addressee> addresses;
        private List<Addressee> skippedAddresses;
        private String serviceCode;
        private String templateCode;
        private Date sendTime = new Date();
        private boolean successful = true;
        private boolean fillSubjectPlaceholders = false;
        private Map<String, Object> model;

        private Builder() {
        }

        public Builder subject(String subject) {
            this.subject = subject;
            return this;
        }

        public Builder requestNumber(String requestNumber) {
            this.requestNumber = requestNumber;
            return this;
        }

        public Builder addresses(List<Addressee> addresses) {
            this.addresses = addresses;
            return this;
        }

        public Builder skippedAddresses(List<Addressee> skippedAddresses) {
            this.skippedAddresses = skippedAddresses;
            return this;
        }

        public Builder serviceCode(String serviceCode) {
            this.serviceCode = serviceCode;
            return this;
        }

        public Builder templateCode(String templateCode) {
            this.templateCode = templateCode;
            return this;
        }

        public Builder sendTime(Date sendTime) {
            this.sendTime = sendTime;
            return this;
        }

        public Builder successful(boolean successful) {
            this.successful = successful;
            return this;
        }

        public Builder fillSubjectPlaceholders(boolean fillSubjectPlaceholders) {
            this.fillSubjectPlaceholders = fillSubjectPlaceholders;
            return this;
        }

        public Builder model(Map<String, Object> model) {
            this.model = model;
            return this;
        }

        public NotificationLogDTO build() {
            return new NotificationLogDTO(subject, requestNumber, addresses, skippedAddresses, serviceCode, templateCode, sendTime, successful, fillSubjectPlaceholders, model);
        }
    }
}