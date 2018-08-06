package mx.com.realstate.administration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * The Class GradleProperties.
 *
 * @author FPLOPEZ Francisco Perez Lopez
 */
@Component
@PropertySource(value = "classpath:gradle.properties", ignoreResourceNotFound = true)
@PropertySource(value = "file:gradle.properties", ignoreResourceNotFound = true)
@ConfigurationProperties
public final class GradleProperties {

  /** The version. */
  private String version;

  /**
   * Gets the version.
   *
   * @return the version
   */
  public String getVersion() {
    return this.version;
  }

  /**
   * Sets the version.
   *
   * @param version the new version
   */
  public void setVersion(final String version) {
    this.version = version;
  }

}