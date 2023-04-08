# Level 3
## Task
Given a set of fighters create a tournament where:  
- after two rounds no rock fighter is left  
- at least one scissors fighters is left  

## Solution
We try to get rid of all rocks by following this strategy:
- While there are rocks:
  - If possible: Append three rocks and one paper
  - Else if possible: Append two rocks and two paper
  - Else if possible: Append two rocks, one paper and one scissor
  - Else if possible: Append one rock and one paper
- Append all papers
- Append all scissors
