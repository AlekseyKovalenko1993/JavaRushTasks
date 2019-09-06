package com.javarush.task.task33.task3310.strategy;

import java.io.IOException;

public class FileStorageStrategy implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;
    FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public FileStorageStrategy() {
        try {
            for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
                table[i] = new FileBucket();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    public Entry getEntry(Long key) {
        try {
            int hash = hash(key);
            int index = indexFor(hash, table.length);
            if (table[index] != null) {
                Entry entry = table[index].getEntry();
                while (entry != null) {
                    if (entry.getKey().equals(key)) {
                        return entry;
                    }
                    entry = entry.next;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;
    }

    public void transfer(FileBucket[] newTable) {
        try {
            for (int i = 0; i < table.length; i++) {
                if (table[i] == null) continue;
                Entry entry = table[i].getEntry();
                while (entry != null) {
                    Entry next = entry.next;
                    int newIndex = indexFor(entry.hash, newTable.length);
                    if (newTable[newIndex] == null) {
                        entry.next = null;
                        newTable[newIndex] = new FileBucket();
                    } else {
                        entry.next = newTable[newIndex].getEntry();
                    }
                    newTable[newIndex].putEntry(entry);
                    entry = next;
                }
                table[i].remove();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        try {
            Entry entry = table[bucketIndex].getEntry();
            table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
            size++;
            if (table[bucketIndex].getFileSize() > bucketSizeLimit)
                resize(2 * table.length);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        try {
            table[bucketIndex] = new FileBucket();
            table[bucketIndex].putEntry(new Entry(hash, key, value, null));
            size++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        try {
            for (int i = 0; i < table.length; i++) {
                if (table[i] == null)
                    continue;

                Entry entry = table[i].getEntry();
                while (entry != null) {
                    if (entry.value.equals(value))
                        return true;

                    entry = entry.next;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        try {
            int hash = hash(key);
            int index = indexFor(hash, table.length);
            if (table[index] != null) {
                Entry entry = table[index].getEntry();
                while (entry != null) {
                    if (entry.getKey().equals(key)) {
                        entry.value = value;
                        return;
                    }
                    entry = entry.next;
                }
                addEntry(hash, key, value, index);
            } else {
                createEntry(hash, key, value, index);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getKey(String value) {
        try {
            for (int i = 0; i < table.length; i++) {
                if (table[i] == null)
                    continue;

                Entry entry = table[i].getEntry();

                while (entry != null) {
                    if (entry.value.equals(value))
                        return entry.key;
                    entry = entry.next;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.value;

        return null;
    }
}