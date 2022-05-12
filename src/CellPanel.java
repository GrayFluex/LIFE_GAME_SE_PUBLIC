public class CellPanel {
    private int rowNum;
    private int colNum;
    private Cell[][] cell = new Cell[500][500];
    public CellPanel(int rowNum,int colNum){
        this.rowNum = rowNum;
        this.colNum = colNum;
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                cell[i][j] = new Cell(i,j);
                cell[i][j].setIsLive(false);
            }
        }
    }

    public int getrowNum() {
        return rowNum;
    }

    public void setrowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getcolNum() {
        return colNum;
    }

    public void setcolNum(int colNum) {
        this.colNum = colNum;
    }
    public boolean getCelrowNumY(int x,int y){
        return cell[x][y].getIsLive();
    }
    public void setCelrowNumY(int x,int y,boolean is){cell[x][y].setIsLive(is);}
    public void randomInit(){//随机初始化
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                cell[i][j].setIsLive(Math.random()>0.5?true:false);
            }
        }
    }
    public void resetCell(){//重新开始
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                cell[i][j].setIsLive(false);
            }
        }
    }
    public void updateCell(){//迭代到下一步
        Cell[][] ctmp = new Cell[rowNum][colNum];
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                ctmp[i][j] = new Cell(i,j);
            }
        }
        for(int i=0;i<rowNum;i++){//迭代逻辑
            for(int j=0;j<colNum;j++){
                int cnt = 0;
                for(int t = i-1;t<=i+1;t++){
                    for(int w = j-1;w<=j+1;w++){
                        if(t>=0&&t<rowNum
                                &&w>=0&&w<colNum
                                &&cell[t][w].getIsLive()){
                            cnt++;
                        }
                    }
                }
                if(cell[i][j].getIsLive()){
                    cnt--;
                }
                if(cnt==3){
                    ctmp[i][j].setIsLive(true);
                }
                else if(cnt==2){
                    ctmp[i][j].setIsLive(cell[i][j].getIsLive());
                }
                else {
                    ctmp[i][j].setIsLive(false);
                }
            }
        }
        for(int i=0;i<rowNum;i++){
            for(int j=0;j<colNum;j++){
                cell[i][j]=ctmp[i][j];
            }
        }
    }
}
