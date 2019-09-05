public class Field {
    private char [][] data;
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = '-';
    public static final char N = 3;

    public Field() {
        this.data = new char[N][N];
        this.init();
    }
    private void init()
    {
        for(int i = 0 ; i < this.data.length ; i ++)
        {
            for (int j = 0 ; j < this.data[i].length; j++)
            {
                this.data[i][j] = EMPTY;
            }
        }

    }
    
    public boolean setValue(int x, int y, char symbol)
    {
        if(x < 0 || x >=this.data[0].length || y < 0 || y >= this.data.length) 
        {
            System.out.println("Выход за границы игрового поля");
            return false;
        }
        if(symbol != X && symbol != O)
        {
            System.out.println("Недопустимый символ: '"+ symbol + "'");
            return false;
        }
        if(this.data[y][x] == EMPTY || this.data[y][x] == 0) this.data[y][x] = symbol;
        else {System.out.println("Поле занято");return false;}
        return true;
    }
    
    public char checkWinner()
    {
        if (    this.data[0][0] == X && this.data[0][1] == X && this.data[0][2] == X ||
                this.data[1][0] == X && this.data[1][1] == X && this.data[1][2] == X ||
                this.data[2][0] == X && this.data[2][1] == X && this.data[2][2] == X ||
                this.data[0][0] == X && this.data[1][0] == X && this.data[2][0] == X ||
                this.data[0][1] == X && this.data[1][1] == X && this.data[2][1] == X ||
                this.data[0][2] == X && this.data[1][2] == X && this.data[2][2] == X ||
                this.data[0][0] == X && this.data[1][1] == X && this.data[2][2] == X ||
                this.data[0][2] == X && this.data[1][1] == X && this.data[2][0] == X) {
            return X;
        } else if (this.data[0][0] == O && this.data[0][1] == O && this.data[0][2] == O ||
                   this.data[1][0] == O && this.data[1][1] == O && this.data[1][2] == O ||
                   this.data[2][0] == O && this.data[2][1] == O && this.data[2][2] == O ||
                   this.data[0][0] == O && this.data[1][0] == O && this.data[2][0] == O ||
                   this.data[0][1] == O && this.data[1][1] == O && this.data[2][1] == O ||
                   this.data[0][2] == O && this.data[1][2] == O && this.data[2][2] == O ||
                   this.data[0][0] == O && this.data[1][1] == O && this.data[2][2] == O ||
                   this.data[0][2] == O && this.data[1][1] == O && this.data[2][0] == O)
        {
            return O;
        }
        return EMPTY;
    }
    
    public boolean isFull()
    {
        for(int i = 0 ; i < this.data.length ; i ++)
        {
            for (int j = 0 ; j < this.data[i].length; j++)
            {
                if(this.data[i][j] == EMPTY || this.data[i][j] == 0) return false;
            }
        }
        return true;
    }
    
    public void printField()
    {
        for(int i = 0 ; i < this.data.length ; i ++)
        {
            for (int j = 0 ; j < this.data[i].length; j++)
            {
                System.out.print((this.data[i][j]==0 || this.data[i][j]==EMPTY)?EMPTY:this.data[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
