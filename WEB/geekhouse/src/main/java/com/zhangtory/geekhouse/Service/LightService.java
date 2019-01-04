package com.zhangtory.geekhouse.Service;

import com.zhangtory.geekhouse.Mqtt.MqttServer;
import com.zhangtory.geekhouse.Utils.CMD;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightService {

    @Autowired
    private MqttServer mqttServer;

    public void lightCtl(String cmd) {
        if ("ON".equals(cmd)) {
            byte[] payload = {0x01, 0x01, 0x50};
            try {
                mqttServer.publish(CMD.LIGHT_COMMAND_TOPIC, payload);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        } else if ("OFF".equals(cmd)) {
            byte[] payload = {0x01, 0x01, 0x14};
            try {
                mqttServer.publish(CMD.LIGHT_COMMAND_TOPIC, payload);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        }
    }

}
