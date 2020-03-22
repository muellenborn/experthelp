package org.wirvsvirus.expertexchange.service.util;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author bahlef
 */
public class CloudFoundryUtil {
	private static final Logger log = LoggerFactory.getLogger(CloudFoundryUtil.class);

	private static final String VCAP_APPLICATION = "VCAP_APPLICATION";

	private static final String VCAP_SERVICES = "VCAP_SERVICES";

	private static final ObjectMapper mapper = new ObjectMapper();

	public static String getUserProvidedVariable(String key) {
		return System.getenv(key);
	}

	@NotNull
	private static String getVcapApplicationString() {
		String vcapApplication = System.getenv(VCAP_APPLICATION);
		if (vcapApplication == null) {
			vcapApplication = "";
		}

		return vcapApplication;
	}

	public static Map<String, Object> getVcapApplication() throws IOException {
		String vcapApplicationString = getVcapApplicationString();
		if (StringUtils.isNotBlank(vcapApplicationString)) {
			Map<String, Object> vcapApplication = mapper.readValue(vcapApplicationString, mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class));
			if (vcapApplication != null) {
				return vcapApplication;
			}
		}

		return Collections.emptyMap();
	}

	public static <V extends Object> V getVcapApplicationProperty(String key, Class<? extends V> returnType) {
		return getVcapApplicationProperty(key, null, returnType);
	}

	public static <V extends Object> V getVcapApplicationProperty(String key, V defaultValue, Class<? extends V> returnType) {
		Map<String, Object> vcap;

		try {
			vcap = getVcapApplication();
		} catch (IOException ex) {
			log.error("Could not parse cloud environment: " + getVcapApplicationString(), ex);

			return defaultValue;
		}

		Object obj = vcap.get(key);
		if (obj != null) {
			if (returnType.isInstance(obj)) {
				return (V) obj;
			} else {
				log.warn("Cloud environment variable '" + key + "' found, but is not of type '" + returnType.getName()
						+ "': " + obj);
			}
		} else {
			log.warn("Cloud environment variable '" + key + "' does not exist: " + getVcapApplicationString());
		}

		return defaultValue;
	}

	@NotNull
	private static String getVcapServicesString() {
		String vcapServices = System.getenv(VCAP_SERVICES);
		if (vcapServices == null) {
			vcapServices = "";
		}

		return vcapServices;
	}

	public static Map<String, Object> getVcapServices() throws IOException {
		String vcapServicesString = getVcapServicesString();
		if (StringUtils.isNotBlank(vcapServicesString)) {
			Map<String, Object> vcapServices = mapper.readValue(vcapServicesString, mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class));
			if (vcapServices != null) {
				return vcapServices;
			}
		}

		return Collections.emptyMap();
	}

	public static List<Map<String, Object>> getServiceInstanceProperties(String serviceName) throws IOException {
		return (List<Map<String, Object>>) getVcapServices().get(serviceName);
	}

	public static Map<String, Map<String, Object>> getUserProvidedServiceCredentials() throws IOException {
		List<Map<String, Object>> userProvidedServices = (List<Map<String, Object>>) CloudFoundryUtil.getVcapServices().get("user-provided");
		Map<String, Map<String, Object>> credentialsMap = userProvidedServices.stream()
				.filter(Objects::nonNull)
				.collect(Collectors.toMap(stringObjectMap -> String.valueOf(stringObjectMap.get("name")), o -> (Map<String, Object>)o.get("credentials")));
		return credentialsMap;
	}

	public static String getSpaceName() {
		return getVcapApplicationProperty("space_name", String.class);
	}

	public static String getAppName() {
		return getVcapApplicationProperty("name", String.class);
	}
}
