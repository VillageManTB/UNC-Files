package a8;

import java.util.*;

public class PasswordManager<K,V> implements Map<K,V> {
    private static final String MASTER_PASSWORD = "TUCKER";
    private Account[] _passwords;
    private int size;

    public PasswordManager() {
        _passwords = new Account[50];
        size = 0;
    }


    // TODO: put
    @Override
    public void put(K key, V value) {
        Account first = new Account(key,value);
        int hash = Math.abs(key.hashCode()) % 50;
        if (_passwords[hash] == null) {
            _passwords[hash] = first;
            size++;
            return;
        }
        Account<K,V> next = _passwords[hash];
        if (next.getWebsite().equals(key)) {
            next.setPassword(value);
            return;
        }
        while (next.getNext() != null && !next.getWebsite().equals(key)) {
            next = next.getNext();
        }
        next.setNext(first);
        size++;
    }

    // TODO: get
    @Override
    public V get(K key) {
        int hash = Math.abs(key.hashCode()) % 50;
        Account now = _passwords[hash];
        while(now != null) {
            if (now.getWebsite().equals(key)) {
                return (V) now.getPassword();
            } else {
                now = now.getNext();
            }
        }
        return null;
    }

    // TODO: size
    @Override
    public int size() {
        return size;
    }

    // TODO: keySet
    @Override
    public Set<K> keySet() {
        Set keys = new HashSet<>();
        for (int i=0; i < _passwords.length;i++) {
            if (_passwords[i] != null) {
                Account new1 = _passwords[i];
                while (new1 != null) {
                    keys.add(new1.getWebsite());
                    new1 = new1.getNext();
                }
            }
        }
        return keys;
    }

    // TODO: remove
    @Override
    public V remove(K key) {
        int hash = Math.abs(key.hashCode()) % 50;
        Account<K,V> current = _passwords[hash];
        if (current == null) {
            return null;
        }
        if(current.getWebsite().equals(key)){
            _passwords[hash] = current.getNext();
            size--;
            return (V) current.getPassword();
        }
        if (current.getNext() != null) {
            while (!current.getNext().getWebsite().equals(key)) {
                current = current.getNext();
                if (current == null) {
                    return null;
                }
            }
        }
        V passwords = (V) current.getNext().getPassword();
        current.setNext(current.getNext().getNext());
        size--;
        return passwords;
    }

    // TODO: checkDuplicate
    @Override
    public List<K> checkDuplicate(V value) {
        List<K> start = new LinkedList<K>();
        for (int i=0; i < _passwords.length;i++) {
            if (_passwords[i] != null) {
                Account new1 = _passwords[i];
                while (new1 != null) {
                    if (new1.getPassword().equals(value)) {
                        start.add((K) new1.getWebsite());
                    }
                    new1 = new1.getNext();
                }
            }
        }
        return start;
    }

    // TODO: checkMasterPassword
    @Override
    public boolean checkMasterPassword(String enteredPassword) {
        if (MASTER_PASSWORD.equals(enteredPassword)) {
            return true;
        }
        return false;
    }

    /*
    Generates random password of input length
     */
    @Override
    public String generateRandomPassword(int length) {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = length;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    /*
    Used for testing, do not change
     */
    public Account[] getPasswords() {
        return _passwords;
    }
}
