package mission.example.basic.Board;

public class BoardDto {
    private String boardName;

    public BoardDto() {
    }

    public BoardDto(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    @Override
    public String toString() {
        return "BoardDto{" +
                "boardName='" + boardName + '\'' +
                '}';
    }
}
