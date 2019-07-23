package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
//import static org.junit.Assert.*;


public class DirtySampleTest {

    //이름이 Aged Brie도 아니고 Buckstage passes to a RAFKAL80ETC concert도 아닐 때
    //퀄리티가 1일 때 이름이 Sulfuras, Hand of Ragnaros도 아니면
    //퀄리티는 1만큼 감소해야한다.
    @Test
    public void AgedBrie아니고_BackstagePasses아니고_퀄리티가_0보다크고_Sulfuras아닐때_Test(){
        Item[] items = {new Item("aaa", 0, 1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(0));

    }

    //이름이 Aged Brie이고 퀄리티는 50보다 작으면 퀄리티는 1 증가해야한다.
    @Test
    public void 이름이_AgedBrie이고_퀄리티는_40이면_퀄리티는_41이어야함(){
        Item[] items = {new Item("Aged Brie",10,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(41));
    }

    //이름이 Backstage이고 sellIn<11 && quality<50이면 quality는 2 증가해야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_10이고_quality가_40이면_quality는_42이어야함(){
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert",10,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(42));
    }

    //이름이 Backstage이고 sellIn<6 && quality<50이면 quality는 3 증가해야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_5이고_quality가_40이면_quality는_43이어야함(){
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert",5,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(43));
    }

    //이름이 sulfuras가 아니면 sellIn은 1 감소 해야한다.
    @Test
    public void 이름이_sulfuras가_아니고_sellIn이_5이면_sellIn은_4이어야함(){
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert",5,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].sellIn, is(4));
    }

    //sellIn이 0보다 작고 이름이 Aged Brie이고 퀄리티가 50보다 작으면
    //퀄리티는 2 증가해야한다.
    @Test
    public void 이름이_AgedBrie이고_sellIn이_0보다_작고_퀄리티가_40이면_퀄리티는_42이어야함(){
        Item[] items = {new Item("Aged Brie",-1,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(42));
    }

    //sellIn이 0보다 작고 이름이 Backstage이면 퀄리티는 0이 되어야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_0보다_작으면_퀄리티는_0(){
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert",-1,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(0));
    }

    //이름이 agedBrie도 아니고 Backstage도 아닌데
    // 퀄리티가 0보다 크고, 이름이 sulfuras도 아니면 퀄리티는 2 감소해야한다.
    @Test
    public void 이름이_Ajou이고_sellIn인_0보다_작고_퀄리티가_30이면_29되어야함(){
        Item[] items = {new Item("Ajou",-1,30)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.updateQuality();
        assertThat(items[0].quality, is(28));
    }
}
