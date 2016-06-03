package com.creeperface.NoteBlockAPI;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.BlockEventPacket;

/**
 * Created with IntelliJ IDEA.
 * User: ml
 * Date: 07.12.13
 * Time: 12:56
 */
public class NoteBlockSongPlayer extends SongPlayer {
    private Block noteBlock;

    private BlockEventPacket pk = new BlockEventPacket();

    public NoteBlockSongPlayer(Song song) {
        super(song);
    }

    public Block getNoteBlock() {
        return noteBlock;
    }

    public void setNoteBlock(Block noteBlock) {
        this.noteBlock = noteBlock;
    }

    @Override
    public void playTick(Player p, int tick) {
        if (noteBlock.getId() != Item.NOTEBLOCK) {
            return;
        }
        if (p.getLevel().getId() != noteBlock.getLevel().getId()) {
            // not in same world
            return;
        }

        for (Layer l : song.getLayerHashMap().values()) {
            Note note = l.getNote(tick);
            if (note == null) {
                continue;
            }

            pk.x = noteBlock.getFloorX();
            pk.y = noteBlock.getFloorY();
            pk.z = noteBlock.getFloorZ();

            pk.case1 = note.getInstrument();
            pk.case2 = (int) NotePitch.getPitch(note.getKey() - 33);
        }
    }
}
