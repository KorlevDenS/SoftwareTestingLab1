package task3;

import com.denis.korolev.task3.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class ObjectModelTest {

    @Nested
    class HorrorParkTest {

        private FogMachine fogMachine;
        private ShadowMachine shadowMachine;
        private Lighting lighting;
        private SoundBar soundBar;


        @BeforeEach
        void setUp() {
            this.fogMachine = new FogMachine(100);
            this.shadowMachine = new ShadowMachine();
            this.lighting = new Lighting(10);
            this.soundBar = new SoundBar(100);
        }

        @Test
        @DisplayName("Check make sound with too much sound level")
        void checkGreaterSoundLevel() {
            Throwable exception = assertThrows(Exception.class, () -> soundBar.playSound(200, SoundEffect.LION));
            assertEquals("Недопустимый уровень звука", exception.getMessage());
        }

        @Test
        @DisplayName("Check make sound with negative sound level")
        void checkNegativeSoundLevel() {
            Throwable exception = assertThrows(Exception.class, () -> soundBar.playSound( -15, SoundEffect.LION));
            assertEquals("Недопустимый уровень звука", exception.getMessage());
        }

        @Test
        @DisplayName("Check turn on lighting without lamps")
        void checkTurnOnLightingWithoutLamps() {
            lighting.setLampsAmount(0);
            Throwable exception = assertThrows(Exception.class, () -> lighting.changeLightMode(LightMode.SHINING));
            assertEquals("Нету лампочек", exception.getMessage());
        }

        @Test
        @DisplayName("Check normal turn on lightning")
        void checkNormalTurnOnLighting() {
            lighting.changeLightMode(LightMode.SHINING);
            assertEquals(LightMode.SHINING, lighting.getLightMode());
        }

        @Test
        @DisplayName("Check show shadow with turned off shadow machine")
        void checkShowShadowWithTurnedOffFogMachine() {
            shadowMachine.setTurnedOn(false);
            Throwable exception = assertThrows(Exception.class, () -> shadowMachine.showShadow(ShadowType.GHOST));
            assertEquals("Машина для теней выключена", exception.getMessage());
        }

        @Test
        @DisplayName("Check normal show shadow")
        void checkNormalShowShadow() {
            shadowMachine.setTurnedOn(true);
            shadowMachine.showShadow(ShadowType.GHOST);
            assertEquals(ShadowType.GHOST, shadowMachine.getShadowType());
        }

        @Test
        @DisplayName("Check make fog without gas")
        void checkMakeFogWithoutGas() {
            Throwable exception = assertThrows(Exception.class, () -> fogMachine.makeFog(10));
            assertEquals("Недостаточно газа", exception.getMessage());
        }

        @Test
        @DisplayName("Check add more gas than can be and negative")
        void checkMakeFogWithWrongGasAmount() {
            Throwable exception1 = assertThrows(Exception.class, () -> fogMachine.addGas(150));
            Throwable exception2 = assertThrows(Exception.class, () -> fogMachine.makeFog(-10));
            assertAll(
                    () -> assertEquals("Объем хранилища ограничен", exception1.getMessage()),
                    () -> assertEquals("Газ не может иметь отрицательный объём", exception2.getMessage())
            );
        }

        @Test
        @DisplayName("Check normal make fog")
        void checkNormalMakeFog() {
            fogMachine.addGas(90);
            fogMachine.makeFog(40);
            assertEquals(90 - 40, fogMachine.getGasLevel());
        }

    }

    @Nested
    class VisitParkTest {

        private HorrorPark horrorPark;
        private Visitor visitor;

        @BeforeEach
        void setUp() {
            this.horrorPark = new HorrorPark(
                    new FogMachine(100),
                    new ShadowMachine(),
                    new Lighting(10),
                    new SoundBar(100),
                    23456654,
                    100
            );
            this.visitor = new Visitor("Ivan", "Ivanov", 18, "муж");
        }

        @Test
        @DisplayName("Check visit park with no ticket")
        void checkVisitParkWithNoTicket() {
            Throwable exception = assertThrows(Exception.class, () -> visitor.visitHorrorPark(horrorPark));
            assertEquals("Билет не куплен", exception.getMessage());
        }

        @Test
        @DisplayName("Check visit park with invalid ticket")
        void checkVisitWithInvalidTicket() {
            Ticket invalidTicket = new Ticket(
                    11111, 150, visitor.getName(), visitor.getSurname(), visitor.getAge());
            visitor.setTicket(invalidTicket);
            Throwable exception = assertThrows(Exception.class, () -> visitor.visitHorrorPark(horrorPark));
            assertEquals("Билет не валидный", exception.getMessage());
        }

        @Test
        @DisplayName("Check buy ticket with few money")
        void checkBuyTicketWithFewMoney() {
            visitor.addMoney(10);
            Throwable exception = assertThrows(Exception.class, () -> visitor.buyTicket(horrorPark));
            assertEquals("Недостаточно средств", exception.getMessage());
        }

        @Test
        @DisplayName("Check buy ticket normal")
        void checkByTicketNormal() {
            visitor.addMoney(200);
            visitor.buyTicket(horrorPark);
            assertAll (
                    () -> assertEquals(visitor.getBalance(), 200 - horrorPark.getTicketPrice()),
                    () -> assertEquals(visitor.getTicket().getHorrorParkId(), horrorPark.getId())
            );
        }

    }

}
