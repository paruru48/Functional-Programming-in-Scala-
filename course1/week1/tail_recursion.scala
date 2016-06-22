package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if(c == 0 || c == r) 1 
      else pascal(c-1, r -1) + pascal(c, r-1)

    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def checkPar(check: Int, par: Char) = {
        if(check >=0 && par == '(')
          check + 1
        else if(par == ')')
          check - 1
        else check
      }
      def helper(pars: List[Char], check: Int):Int = {
        if(pars.isEmpty)
          check
        else
          helper(pars.tail, checkPar(check, pars.head))
      }
      helper(chars, 0) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if(money == 0)
        1
      else if (money < 0)
        0
      else if(coins.length <=0 && money >=1)
        0
      else
        countChange(money, coins.dropRight(1)) + countChange(money - coins.last, coins)
    }
  }
