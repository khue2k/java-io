package org.example.objectOutputStream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

@Data
@AllArgsConstructor
public class GameSetting implements Serializable {
    private static final long serialVersionId = 1L;
    private int sound;
    private int bright;
    private String difficultyLevel;
    private String userNote;

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        this.sound = fields.get("sound", 50);
        this.bright = fields.get("bright", 70);
        this.difficultyLevel = (String) fields.get("difficultyLevel", "Easy");
        if (this.difficultyLevel == null) {
            this.difficultyLevel = "Easy";
        }
        this.userNote = (String) fields.get("userNote", "Have fun");
        if (this.userNote == null) {
            this.userNote = "Have fun";
        }
    }
}
