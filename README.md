# ajou-dirtycode
Dirty code for refactoring

1. 먼저 test package를 생성하고 test에 필요한 몇가지 import를 수행했다.
그리고 코드를 분석한 결과 

  item[].name이 Aged Brie일 때, Backstage passes to a TAFKAL80ETC concert일 때, Sulfuras, Hand of Ragnaros일 때와 그 외로 나뉘고
  item[].quality가 0이하, 0에서50사이, 50이상일 때로 나뉘고
  itme[].sellin이 0이하, 0에서6사이, 6에서11사이, 11이상일 때로 나뉘는 것을 알 수 있었다.

이 코드는 상품의 질을 sellIn과 이름에 따라 변동시키는 코드다.

2. 이를 바탕으로 아이템의 필드값의 조건으로 모든 경우의 수를 나눠서 테스트 코드를 작성하였다. 경우의 수를 나눈 우선순위는 " 이름> sellin > quality " 순이다.

- 아이템의 이름

아래 3개의 이름 중 아무것도 아닐 때

이름이 "Aged Brie" 일 때

이름이 "Backstage passes to a TAFKAL80ETC concert"

이름이 "Sulfuras, Hand of Ragnaros"

-아이템의 Sellin

Sellin < 0

0 <= Sellin < 6

6 <= Sellin < 11

11<= Sellin

-아이템의 quality

quality <= 0

0 < quality <50

50 <= quality

3. refactoring은 다음과 같이 수행하였다.

  - 먼저 주어진 코드를 작은 기능 단위로 쪼개 method를 만들어 코드를 간단히 해보았다.
  코드의 라인수가 많이 줄어들고 보기에 깔끔해 보였지만 직관적으로 다가오지 않았다. 
  - 하지만 if문에 부정문이 많고 쪼개놓은 method 들이 명확하게 이해되지 않았다.
  그래서 if문을 모두 긍정문으로 바꾸고 테스트 코드에서와 동일하게 이름을 우선순위로 하여 이름별로 method를 구성할 수 있게 코드를 수정하였다. 
  - 파라미터의 변수가 무엇을 의미하는지 나타나지 않아서 최대한 역할을 나타내도록 이름을 바꿨다.
