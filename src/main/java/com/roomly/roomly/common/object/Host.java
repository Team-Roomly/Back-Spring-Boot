package com.roomly.roomly.common.object;

import com.roomly.roomly.entity.HostEntity;
import com.roomly.roomly.repository.resultSet.HostResultSet;

import lombok.Getter;

import java.util.List;
import java.util.ArrayList;

@Getter
public class Host {

    private String hostId;
    private String hostName;
    private Boolean entryStatus;
    

    public Host(HostEntity hostEntity){
        this.hostId = hostEntity.getHostId();
        this.hostName = hostEntity.getHostName();
        this.entryStatus = hostEntity.getEntryStatus();
    }

    public static List<Host> getHosts(List<HostEntity> hostEntities){
        List<Host> hosts = new ArrayList<>();
        for (HostEntity hostEntity : hostEntities){
            Host host = new Host(hostEntity);
            hosts.add(host);
        }
        return hosts;
    }
    
}