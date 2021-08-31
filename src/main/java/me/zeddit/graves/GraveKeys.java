package me.zeddit.graves;

import org.bukkit.NamespacedKey;


public enum GraveKeys implements Keyable<GraveKeys> {
    GRAVE_OWNER("graveOwner"),
    EXPIRY("expiry"),
    INVENTORY_SIZE("invSize");

    private final String value;
    //This needs to be lazy initialised to avoid GravesMain.getInstance resolving to null.
    private NamespacedKey key = null;


    GraveKeys(String value) {
        this.value = value;
    }

    @Override
    public NamespacedKey toKey() {
        if (key == null) {
            key = new NamespacedKey(GravesMain.getInstance(), value);
        }
        return key;
    }

    public static GraveKeys fromKey(NamespacedKey key) {
        for (GraveKeys i : GraveKeys.values()) {
            if (key.value().equals(i.value)) {
                return i;
            }
        }
        return null;
    }
}

interface Keyable<T> {
    NamespacedKey toKey();
}
