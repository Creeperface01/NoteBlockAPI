package com.creeperface.NoteBlockAPI;

import cn.nukkit.event.HandlerList;
import cn.nukkit.event.plugin.PluginEvent;

public class SongStoppedEvent extends PluginEvent {
    private static final HandlerList handlers = new HandlerList();

    private SongPlayer song;

    public SongStoppedEvent(NoteBlockPlayerMain plugin, SongPlayer song) {
        super(plugin);
        this.song = song;
    }

    public SongPlayer getSongPlayer() {
        return song;
    }
}
