package teammates.storage.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.OnSave;
import com.googlecode.objectify.annotation.Translate;

/**
 * Represents user-specific settings in the system.
 */
@Entity
@Index
public class UserSettings extends BaseEntity {

    @Id
    private String id;

    // Add fields to represent user-specific settings here.
    // Example:
    private boolean emailNotificationsEnabled;
    private boolean darkModeEnabled;

    @Translate(InstantTranslatorFactory.class)
    private Instant updatedAt;

    @SuppressWarnings("unused")
    private UserSettings() {
        // required by Objectify
    }

    /**
     * Instantiates a new user settings object with default settings.
     * You can modify this constructor to initialize the settings fields.
     */
    public UserSettings() {
        // Initialize user-specific settings with default values.
        this.emailNotificationsEnabled = true;
        this.darkModeEnabled = false;
        this.updatedAt = Instant.now();
    }

    public String getId() {
        return id;
    }

    public boolean isEmailNotificationsEnabled() {
        return emailNotificationsEnabled;
    }

    public void setEmailNotificationsEnabled(boolean emailNotificationsEnabled) {
        this.emailNotificationsEnabled = emailNotificationsEnabled;
    }

    public boolean isDarkModeEnabled() {
        return darkModeEnabled;
    }

    public void setDarkModeEnabled(boolean darkModeEnabled) {
        this.darkModeEnabled = darkModeEnabled;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Updates the updatedAt timestamp when saving.
     */
    @OnSave
    public void updateLastUpdateTimestamp() {
        this.updatedAt = Instant.now();
    }
}
