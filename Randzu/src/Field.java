public class Field {
    private char [][] data;
    private int countToWin;
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY = '-';
    //public static final int N = 10;
    //public static final int COUNT_TO_WIN = 3;

    public Field(int countToWin, int X, int Y) {
        this.data = new char[X][Y];
        this.countToWin = countToWin;
        this.init();
    }

    public void initTest()
    {
        this.init();
        this.data[0][0] = X;this.data[0][1] = X;this.data[0][2] = X;this.data[0][3] = X;this.data[0][4] = X;
        this.data[1][0] = O;this.data[2][0] = O;this.data[3][0] = O;this.data[4][0] = O;this.data[5][0] = O;
        this.data[1][1] = X;this.data[2][2] = X;this.data[3][3] = X;this.data[4][4] = X;this.data[5][5] = X;
        this.data[0][9] = O;this.data[1][8] = O;this.data[2][7] = O;this.data[3][6] = O;this.data[4][5] = O;
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
        if(x < 0 || x >= this.data[0].length || y < 0 || y >= this.data.length)
        {
            System.out.println("Выход за границы игрового поля");
            return false;
        }
        if(symbol != X && symbol != O)
        {
            System.out.println("Недопустимый символ: '"+ symbol + "'");
            return false;
        }
        if(this.data[x][y] == EMPTY || this.data[x][y] == 0) this.data[x][y] = symbol;
        else {System.out.println("Поле занято");return false;}
        return true;
    }
    
    private int getLBoundX(int x)
    {
        if(x - this.countToWin <= 0) return 0;
        else return x-this.countToWin;
    }
    private int getLBoundY(int y)
    {
        if(y - this.countToWin <= 0) return  0;
        else return y - this.countToWin;
    }
    private int getRBoundX(int x, int y)
    {
        if(x + this.countToWin >= this.data[y].length) return this.data[y].length;
        else return x + this.countToWin;
    }
    private int getRBoundY(int y)
    {
        if(y + this.countToWin >= this.data.length) return this.data.length;
        else return y + this.countToWin;
    }
    
    //public
    private boolean checkHorizontal(int x, int y, char symbol)
    {
        int countToWin = 0;
        for(int i = this.getLBoundX(x) ; i < this.getRBoundX(x,y) ; i++)
        {
            if(this.data[y][i] == symbol) countToWin++;
            else countToWin = 0;
            if(countToWin >= this.countToWin) return true;
        }
        return false;
    }
    
    //public
    private boolean checkVertical(int x, int y, char symbol)
    {
        int countToWin = 0;
        for(int j = this.getLBoundY(y) ; j < this.getRBoundY(y) ; j++)
        {
            if(this.data[j][x] == symbol) countToWin++;
            else {countToWin = 0;}
            if(countToWin >= this.countToWin) return true;
        }
        return false;
    }
    
    //public
    private boolean checkRightDiagonal(int x, int y, char symbol)
    {
        int countToWin = 0;

        for(int i = y - 1,  j = x + 1 ; i >= this.getLBoundY(y) && j < this.getRBoundX(x,y); i--,j++)
        {
            if(this.data[i][j] == symbol) countToWin++;
            else {countToWin = 0;}
            if(countToWin >= this.countToWin) return true;
        }

        for(int i = y, j = x  ; i < this.getRBoundY(y) && j >= this.getLBoundX(x); i++, j--)
        {
            if(this.data[i][j] == symbol) countToWin++;
            else {countToWin = 0;}
            if(countToWin >= this.countToWin) return true;
        }
        return  false;
    }
    
    //public
    private boolean checkLeftDiagonal(int x, int y, char symbol)
    {
        int countToWin = 0;

        for(int i = this.getLBoundY(y), j = this.getLBoundX(x) ;
            i <this.getRBoundY(y) && j < this.getRBoundX(x,y) ;
            i++, j++)
        {
            if(this.data[i][j] == symbol) countToWin++;
            else {countToWin = 0;}
            if(countToWin >= this.countToWin) return true;
        }
        return false;
    }
    
    public char checkWinner(int x, int y, char symbol)
    {
        if (    this.checkHorizontal(x, y, symbol)    ||
                this.checkVertical(x, y, symbol)      ||
                this.checkRightDiagonal(x, y, symbol) ||
                this.checkLeftDiagonal(x, y, symbol)   ) 
        {return symbol;}
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
                System.out.print(((this.data[i][j] == 0 || this.data[i][j] == EMPTY)?EMPTY:this.data[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
