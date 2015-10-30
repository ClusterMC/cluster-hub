package org.theclustermc.hub.player;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of Hub.
 * 
 * Hub can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import lombok.Getter;

import java.util.List;

public enum Setting{

    CHAT_MENTION(Boolean.class, Object),
    SHOW_PLAYERS(Boolean.class),
    SERVER_ON_LOGIN(String.class),
    USE_RIFT(Boolean.class),
    ALLOW_MESSAGES(Boolean.class),
    IGNORED(List.class); //Of uuids

    @Getter
    private Class clazz;

    Setting(Class booleanClass) {

    }
}
