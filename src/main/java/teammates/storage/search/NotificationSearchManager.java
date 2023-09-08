package teammates.storage.search;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;

import teammates.common.datatransfer.attributes.NotificationAttributes;
import teammates.common.exception.SearchServiceException;
import teammates.storage.api.NotificationsDb;

import java.util.Comparator;
import java.util.List;

public class NotificationSearchManager extends SearchManager<NotificationAttributes> {

    private final NotificationsDb notificationsDb = NotificationsDb.inst();

    public NotificationSearchManager(String searchServiceHost, boolean isResetAllowed) {
        super(searchServiceHost, isResetAllowed);
    }

    @Override
    String getCollectionName() {
        return "notifications";
    }

    @Override
    NotificationSearchDocument createDocument(NotificationAttributes notification) {
        return new NotificationSearchDocument(notification);
    }

    @Override
    NotificationAttributes getAttributeFromDocument(SolrDocument document) {
        // Implement how to retrieve attributes from SolrDocument
        // For example:
        // String notificationId = (String) document.getFirstValue("notificationId");
        // return notificationsDb.getNotificationById(notificationId);
        return null; // Placeholder, replace with actual code
    }

    @Override
    void sortResult(List<NotificationAttributes> result) {
        // Implement how to sort the result list
        // For example:
        // result.sort(Comparator.comparing(NotificationAttributes::getCreatedAt).reversed());
    }

    /**
     * Searches for notifications.
     *
     * @param queryString the query string for the search
     * @return a list of matching notifications
     * @throws SearchServiceException if an error occurs during the search
     */
    public List<NotificationAttributes> searchNotifications(String queryString) throws SearchServiceException {
        SolrQuery query = getBasicQuery(queryString);

        QueryResponse response = performQuery(query);
        return convertDocumentToAttributes(response.getResults());
    }
}
