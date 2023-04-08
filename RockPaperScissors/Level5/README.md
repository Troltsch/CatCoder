# Level 5
## Task
Same as level 4 but this time the game is called:  
Rock, paper, scissor, lizard, Spock.

## Solution
This problem is currently unsolved.
It might be possible to approch this problem the following:
- Use the similar strategy as before by dividing the total size of participants into a "left wing"
- We need to get rid of rocks and Spocks first, but we can utilize Spocks to get also rid of some rocks!
- Try to get rid of rocks first:  
  - Use at least one paper and else spocks, should look like this (pattern might vary depending on "left wing" size):
    - PR RR YR RR
    - PR RR YR RR YR RR RR RR
  - If there are no more spocks you can use papers instead (or mix if necessary): 
    - PR RR PR RR
    - PR RR YR RR YR RR RR RR
    - PR RR YR RR PR RR RR RR
  - If there are no more rocks get rid of Spocks by using lizards and papers
  - Put a scissor in the end