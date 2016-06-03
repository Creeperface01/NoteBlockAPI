package com.creeperface.NoteBlockAPI;

import cn.nukkit.event.HandlerList;
import cn.nukkit.event.plugin.PluginEvent;

public class SongEndEvent extends PluginEvent {

    private static final HandlerList handlers = new HandlerList();
    private SongPlayer song;

    public SongEndEvent(NoteBlockPlayerMain plugin, SongPlayer song) {
        super(plugin);
        this.song = song;
    }

    public SongPlayer getSongPlayer() {
        return song;
    }
}
