package ac.kr.ajou.dirt;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class DirtySampleTest {

    public static final String NONE_OF_THREE_NAMES = "Refactoring!!";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String TAFKAL80ETC = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";


    //이름이 AGED_BRIE , TAFKAL80ETC, SULFURAS 셋 다 아니고 퀄리티가 0보다 크면 퀄리티는 1만큼 감소해야한다.
    @Test
    public void 이름이_셋다_아니고_quailty가_1이면_0이_되어야함(){
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 0, 1)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality,is(0));
    }

    //이름이 AGED_BRIE이고 퀄리티가 50보다 작으면 퀄리티는 1만큼 증가해야한다.
    @Test
    public void 이름이_AgedBrie이고_퀄리티는_40이면_퀄리티는_41이어야함(){
        Item[] items = {new Item(AGED_BRIE,10,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(41));
    }

    //이름이 TAFKAL80ETC이고 sellIn<11 && quality<50이면 quality는 2만큼 증가해야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_10이고_quality가_40이면_quality는_42이어야함(){
        Item[] items = {new Item(TAFKAL80ETC,10,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(42));
    }

    //이름이 TAFKAL80ETC이고 sellIn<6 && quality<50이면 quality는 3 증가해야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_5이고_quality가_40이면_quality는_43이어야함(){
        Item[] items = {new Item(TAFKAL80ETC,5,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(43));
    }

    //이름이 sulfuras가 아니면 sellIn은 1 감소 해야한다.
    @Test
    public void 이름이_sulfuras가_아니고_sellIn이_5이면_sellIn은_4이어야함(){
        Item[] items = {new Item(TAFKAL80ETC,5,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].sellIn, is(4));
    }

    //sellIn이 0보다 작고 이름이 Aged Brie이고 퀄리티가 50보다 작으면 퀄리티는 2 증가해야한다.
    @Test
    public void 이름이_AgedBrie이고_sellIn이_0보다_작고_퀄리티가_40이면_퀄리티는_42이어야함(){
        Item[] items = {new Item(AGED_BRIE,-1,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(42));
    }

    //sellIn이 0보다 작고 이름이 Backstage이면 퀄리티는 0이 되어야한다.
    @Test
    public void 이름이_Backstage이고_sellIn이_0보다_작으면_퀄리티는_0(){
        Item[] items = {new Item(TAFKAL80ETC,-1,40)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(0));
    }

    //이름이 셋 다 해당되지 않고 sellIn이 0보다 작고
    // 퀄리티가 0보다 크면 퀄리티는 2 감소해야한다.
    @Test
    public void 이름이_셋다아니고_sellIn인_0보다_작고_퀄리티가_30이면_29되어야함(){
        Item[] items = {new Item(NONE_OF_THREE_NAMES,-1,30)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();
        assertThat(items[0].quality, is(28));
    }

////////////////////////////////////////////////////////////////////////////

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(23));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(58));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(24));
    }

    @Test
    public void doSomething_이름이셋다아니고_sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(NONE_OF_THREE_NAMES, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(59));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(-3));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(27));
    }

    @Test
    public void doSomething_이름이AGEDBRIEC이고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(60));
    }
    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(AGED_BRIE, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(AGED_BRIE, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이AGEDBRIE이고sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(AGED_BRIE, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(TAFKAL80ETC, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(0));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(TAFKAL80ETC, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(0));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(TAFKAL80ETC, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-6));
        assertThat(items[0].quality, is(0));
    }
    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(TAFKAL80ETC, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(-2));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(TAFKAL80ETC, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(28));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(TAFKAL80ETC, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(2));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(TAFKAL80ETC, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(-3));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(TAFKAL80ETC, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(27));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(TAFKAL80ETC, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(7));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(TAFKAL80ETC, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(-4));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(TAFKAL80ETC, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(26));
    }

    @Test
    public void doSomething_이름이TAFKAL80ETC이고sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(TAFKAL80ETC, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(12));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이음수이고_quailty가음수일때() {
        Item[] items = {new Item(SULFURAS, -5, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-5));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이음수이고_quailty가25일때() {
        Item[] items = {new Item(SULFURAS, -5, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-5));
        assertThat(items[0].quality, is(25));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이음수이고_quailty가60일때() {
        Item[] items = {new Item(SULFURAS, -5, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(-5));
        assertThat(items[0].quality, is(60));
    }
    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이3이고_quailty가음수일때() {
        Item[] items = {new Item(SULFURAS, 3, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(3));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이3이고_quailty가25일때() {
        Item[] items = {new Item(SULFURAS, 3, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(3));
        assertThat(items[0].quality, is(25));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이3이고_quailty가60일때() {
        Item[] items = {new Item(SULFURAS, 3, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(3));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이8이고_quailty가음수일때() {
        Item[] items = {new Item(SULFURAS, 8, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(8));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이8이고_quailty가25일때() {
        Item[] items = {new Item(SULFURAS, 8, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(8));
        assertThat(items[0].quality, is(25));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이8이고_quailty가60일때() {
        Item[] items = {new Item(SULFURAS, 8, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(8));
        assertThat(items[0].quality, is(60));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이13이고_quailty가음수일때() {
        Item[] items = {new Item(SULFURAS, 13, -5)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(13));
        assertThat(items[0].quality, is(-5));
    }

    @Test
    public void doSomething_이름이SULFURAS이고_sellIn이13이고_quailty가25일때() {
        Item[] items = {new Item(SULFURAS, 13, 25)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(13));
        assertThat(items[0].quality, is(25));
    }

    @Test
    public void doSomething_이름이SULFURAS이고sellIn이13이고_quailty가60일때() {
        Item[] items = {new Item(SULFURAS, 13, 60)};
        DirtySample dirtySample = new DirtySample(items);
        dirtySample.UpdateQuality_And_SellIn();

        assertThat(items[0].sellIn, is(13));
        assertThat(items[0].quality, is(60));
    }
}
