package com.creeperface.NoteBlockAPI;

import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.event.plugin.PluginEvent;

public class SongDestroyingEvent extends PluginEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    private SongPlayer song;

    public SongDestroyingEvent(NoteBlockPlayerMain plugin, SongPlayer song) {
        super(plugin);
        this.song = song;
    }

    public SongPlayer getSongPlayer() {
        return song;
    }
}
