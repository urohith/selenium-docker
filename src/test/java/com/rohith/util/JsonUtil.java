package com.rohith.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rohith.tests.flightreservation.model.FlightPortalTestData;
import com.rohith.tests.vendorPortal.VendorPortalTest;
import com.rohith.tests.vendorPortal.model.VendorPortalTestData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.io.InputStream;

public class JsonUtil
{
    public static final Logger log = LoggerFactory.getLogger(JsonUtil.class);
//    Responsible for converting input stream to java objects
    private static final ObjectMapper mapper = new ObjectMapper();
    public static <T> T getTestData(String path,Class<T> type) throws IOException
    {
        try(InputStream stream = ResourceLoader.getResources(path))
        {
            return mapper.readValue(stream,type);
        }
        catch (Exception ex)
        {
            log.error("Unable to read test data {}",path,ex);
        }
        return null;
    }
}
