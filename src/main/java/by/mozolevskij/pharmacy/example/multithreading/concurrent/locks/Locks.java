package by.mozolevskij.pharmacy.example.multithreading.concurrent.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Locks {

    /**
     *
     * Locks - включает классы кторые можно использовать для блокироки
     * ресурсов с определенными условиями, отлчиающимися от синхронизации
     * и монитора, паект более гибкий
     * Управляет доступом к одному ресурсу нескольким потокам
     *
     * Включает:
     * - Lock
     * - Condition
     * - ReadWriteLock
     *
     * ReintnantLock, try-finaly - обязательный, т.к. в блоке finally
     * вызывается даже при ошибке lock.unlock(), он должен быть
     * выполнен
     *
     * ReintnantLock так же, следуя из названия (Возвращающийся) может
     * быть заблокирован несколько раз, и следовательно для
     * разблокировки ресурса добжен быть разблокирован столько же раз
     *
     * Если поток который сделал блокировку пытается сделать ее
     * еще раз для этого же Lock-а, поток будет заблокирован,
     * если в это время потоки будут бытаться заблокировать этот
     * Lock, то они тоже будут заблеированы навсехда
     * называется БЛОКИРОВКА ПОВТОРНОГО ВХОДА
     *
     * После разблокировки ресурса нет гарантий какой поток заберет
     * этот ресурс, это может привети к проблемам связанным с блокирокой
     * из-за непредсказуемости подачи потоков, решение:
     * Lock lk = new ReentrantLock(true); - потоки после разблокировки
     * Lock будут захватывать ресурс последовательно
     *
     * await() - wait()
     * signal()/signalAll() - notify()/notifyAll()
     *
     * */

    public static void main(String[] args) {
        iterupted();
        someLock();
        tryLockTrue();
        tryLockFalse();
    }

    //
    public static void someLock() {
        Lock lk = new ReentrantLock();
        lk.lock();
        try {
            // доступ к защищенному блокировкой ресурсу
        } finally {
            // освобождение блокировки
            lk.unlock();
        }
    }

    // lock.lockInterruptibly() - блокирует Lock, если поток прерван
    public static void iterupted() {
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            lock.unlock();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    //lock.tryLock() - возвращает boolean, пытается заблкировать Lock,
    //если не получается, возвращает false - не ожидает пока другой
    // поток разблокирует Lock, а продолжает работу, иначе - вернет true
    public static void tryLockTrue() {
        Lock lock = new ReentrantLock();
        try {
            boolean tryLock = lock.tryLock();
            System.out.println("Lock successful: " + tryLock);
        } finally {
            lock.unlock();
        }
    }

    private static void tryLockFalse() {
        Lock lock = new ReentrantLock();
        try {
            boolean tryLock = lock.tryLock();
            System.out.println("Lock successful: " + tryLock);
        } finally {
            lock.unlock();
        }
    }
}
