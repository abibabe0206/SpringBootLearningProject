package com.example.SpringBootLearningProject.customEndPoints;

import com.example.SpringBootLearningProject.actuatorService.CustomInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Endpoint(id = "custom-endpoint")
@Slf4j
public class CustomEndPoint {

    protected List<CustomInfo> customInfoList = new ArrayList<>();

    public CustomEndPoint() {
        customInfoList.add(new CustomInfo("john", 15));
        customInfoList.add(new CustomInfo("david", 20));
        customInfoList.add(new CustomInfo("micheal", 37));
        customInfoList.add(new CustomInfo("joy", 29));
        customInfoList.add(new CustomInfo("faith", 19));
        customInfoList.add(new CustomInfo("hope", 5));
        log.debug("Customs created {}", customInfoList.toString());
    }

    @ReadOperation
    public List<CustomInfo> custom() {
        return customInfoList;
    }

    @ReadOperation
    public CustomInfo customEndPointByName(@Selector String  name) {
        for (CustomInfo c : customInfoList) {
            if (c.getName().equals(name)) {
                return c;
            } else if (Objects.equals(name, String.valueOf(c.getAge()))){
                return c;
            }
        }
        return null;
    }


    @WriteOperation
    public List<CustomInfo> addCustom(@Selector String name, int age) {
        CustomInfo customInfo = new CustomInfo(name, age);
        log.debug("adding a custom \n{}", customInfo );
        customInfoList.add(customInfo);
        return customInfoList;
    }
}

