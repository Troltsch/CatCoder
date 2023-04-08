# Level 4
## Task
Given a set of fighters generate a tournament where:  
- the final winner, after all rounds, is a scissor

## Solution
We approched this problem by dividing the total number of participants in the tournament each iteration.  
Each divided tournament needs to result either:
- a winning scissor
- or a winning paper

The most right tournament is guranteed to be a scissor winner, which will result in the scissor beating all the papers.

Now to the strategy:
- Divide the current total number of participants by two into a "left wing"
  - Check if there is at least one paper and one rock and append it to the resulting tournament string.
  - While the "left wing" isn't totally filled:
    - fill it with rocks
    - if there are no more rocks: fill with papers
    - and if there are no more rocks: use scissors
  - After the current left wing is totally filled create a new "left wing" by dividing the left total number of participants by two and start over 
- In the end append the last scissor
