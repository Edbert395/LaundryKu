package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.NativeContext;
import io.realm.internal.OsList;
import io.realm.internal.OsMap;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSet;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.core.NativeRealmAny;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_myapplication_menu_user_UserRealmProxy extends com.example.myapplication.menu.user.User
    implements RealmObjectProxy, com_example_myapplication_menu_user_UserRealmProxyInterface {

    static final class UserColumnInfo extends ColumnInfo {
        long emailColKey;
        long passwordColKey;
        long fullNameColKey;
        long phoneNumberColKey;
        long birthPlaceColKey;
        long birthDateColKey;

        UserColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("User");
            this.emailColKey = addColumnDetails("email", "email", objectSchemaInfo);
            this.passwordColKey = addColumnDetails("password", "password", objectSchemaInfo);
            this.fullNameColKey = addColumnDetails("fullName", "fullName", objectSchemaInfo);
            this.phoneNumberColKey = addColumnDetails("phoneNumber", "phoneNumber", objectSchemaInfo);
            this.birthPlaceColKey = addColumnDetails("birthPlace", "birthPlace", objectSchemaInfo);
            this.birthDateColKey = addColumnDetails("birthDate", "birthDate", objectSchemaInfo);
        }

        UserColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new UserColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final UserColumnInfo src = (UserColumnInfo) rawSrc;
            final UserColumnInfo dst = (UserColumnInfo) rawDst;
            dst.emailColKey = src.emailColKey;
            dst.passwordColKey = src.passwordColKey;
            dst.fullNameColKey = src.fullNameColKey;
            dst.phoneNumberColKey = src.phoneNumberColKey;
            dst.birthPlaceColKey = src.birthPlaceColKey;
            dst.birthDateColKey = src.birthDateColKey;
        }
    }

    private static final String NO_ALIAS = "";
    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private UserColumnInfo columnInfo;
    private ProxyState<com.example.myapplication.menu.user.User> proxyState;

    com_example_myapplication_menu_user_UserRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (UserColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.myapplication.menu.user.User>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailColKey);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'email' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$password() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.passwordColKey);
    }

    @Override
    public void realmSet$password(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.passwordColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.passwordColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.passwordColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.passwordColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fullName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fullNameColKey);
    }

    @Override
    public void realmSet$fullName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fullNameColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.fullNameColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fullNameColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fullNameColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$phoneNumber() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.phoneNumberColKey);
    }

    @Override
    public void realmSet$phoneNumber(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.phoneNumberColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.phoneNumberColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.phoneNumberColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.phoneNumberColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$birthPlace() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthPlaceColKey);
    }

    @Override
    public void realmSet$birthPlace(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthPlaceColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthPlaceColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthPlaceColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthPlaceColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$birthDate() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.birthDateColKey);
    }

    @Override
    public void realmSet$birthDate(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.birthDateColKey, row.getObjectKey(), true);
                return;
            }
            row.getTable().setString(columnInfo.birthDateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.birthDateColKey);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.birthDateColKey, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder(NO_ALIAS, "User", false, 6, 0);
        builder.addPersistedProperty(NO_ALIAS, "email", RealmFieldType.STRING, Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "password", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "fullName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "phoneNumber", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "birthPlace", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty(NO_ALIAS, "birthDate", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static UserColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new UserColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "User";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "User";
    }

    @SuppressWarnings("cast")
    public static com.example.myapplication.menu.user.User createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.myapplication.menu.user.User obj = null;
        if (update) {
            Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
            UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class);
            long pkColumnKey = columnInfo.emailColKey;
            long objKey = Table.NO_MATCH;
            if (json.isNull("email")) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, json.getString("email"));
            }
            if (objKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class), false, Collections.<String> emptyList());
                    obj = new io.realm.com_example_myapplication_menu_user_UserRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("email")) {
                if (json.isNull("email")) {
                    obj = (io.realm.com_example_myapplication_menu_user_UserRealmProxy) realm.createObjectInternal(com.example.myapplication.menu.user.User.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.com_example_myapplication_menu_user_UserRealmProxy) realm.createObjectInternal(com.example.myapplication.menu.user.User.class, json.getString("email"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'email'.");
            }
        }

        final com_example_myapplication_menu_user_UserRealmProxyInterface objProxy = (com_example_myapplication_menu_user_UserRealmProxyInterface) obj;
        if (json.has("password")) {
            if (json.isNull("password")) {
                objProxy.realmSet$password(null);
            } else {
                objProxy.realmSet$password((String) json.getString("password"));
            }
        }
        if (json.has("fullName")) {
            if (json.isNull("fullName")) {
                objProxy.realmSet$fullName(null);
            } else {
                objProxy.realmSet$fullName((String) json.getString("fullName"));
            }
        }
        if (json.has("phoneNumber")) {
            if (json.isNull("phoneNumber")) {
                objProxy.realmSet$phoneNumber(null);
            } else {
                objProxy.realmSet$phoneNumber((String) json.getString("phoneNumber"));
            }
        }
        if (json.has("birthPlace")) {
            if (json.isNull("birthPlace")) {
                objProxy.realmSet$birthPlace(null);
            } else {
                objProxy.realmSet$birthPlace((String) json.getString("birthPlace"));
            }
        }
        if (json.has("birthDate")) {
            if (json.isNull("birthDate")) {
                objProxy.realmSet$birthDate(null);
            } else {
                objProxy.realmSet$birthDate((String) json.getString("birthDate"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.myapplication.menu.user.User createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.example.myapplication.menu.user.User obj = new com.example.myapplication.menu.user.User();
        final com_example_myapplication_menu_user_UserRealmProxyInterface objProxy = (com_example_myapplication_menu_user_UserRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("password")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$password((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$password(null);
                }
            } else if (name.equals("fullName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fullName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fullName(null);
                }
            } else if (name.equals("phoneNumber")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$phoneNumber((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$phoneNumber(null);
                }
            } else if (name.equals("birthPlace")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$birthPlace((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$birthPlace(null);
                }
            } else if (name.equals("birthDate")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$birthDate((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$birthDate(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'email'.");
        }
        return realm.copyToRealmOrUpdate(obj);
    }

    static com_example_myapplication_menu_user_UserRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class), false, Collections.<String>emptyList());
        io.realm.com_example_myapplication_menu_user_UserRealmProxy obj = new io.realm.com_example_myapplication_menu_user_UserRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.example.myapplication.menu.user.User copyOrUpdate(Realm realm, UserColumnInfo columnInfo, com.example.myapplication.menu.user.User object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.myapplication.menu.user.User) cachedRealmObject;
        }

        com.example.myapplication.menu.user.User realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
            long pkColumnKey = columnInfo.emailColKey;
            String value = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$email();
            long objKey = Table.NO_MATCH;
            if (value == null) {
                objKey = table.findFirstNull(pkColumnKey);
            } else {
                objKey = table.findFirstString(pkColumnKey, value);
            }
            if (objKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(objKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.com_example_myapplication_menu_user_UserRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.example.myapplication.menu.user.User copy(Realm realm, UserColumnInfo columnInfo, com.example.myapplication.menu.user.User newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.myapplication.menu.user.User) cachedRealmObject;
        }

        com_example_myapplication_menu_user_UserRealmProxyInterface unmanagedSource = (com_example_myapplication_menu_user_UserRealmProxyInterface) newObject;

        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.emailColKey, unmanagedSource.realmGet$email());
        builder.addString(columnInfo.passwordColKey, unmanagedSource.realmGet$password());
        builder.addString(columnInfo.fullNameColKey, unmanagedSource.realmGet$fullName());
        builder.addString(columnInfo.phoneNumberColKey, unmanagedSource.realmGet$phoneNumber());
        builder.addString(columnInfo.birthPlaceColKey, unmanagedSource.realmGet$birthPlace());
        builder.addString(columnInfo.birthDateColKey, unmanagedSource.realmGet$birthDate());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_example_myapplication_menu_user_UserRealmProxy managedCopy = newProxyInstance(realm, row);
        cache.put(newObject, managedCopy);

        return managedCopy;
    }

    public static long insert(Realm realm, com.example.myapplication.menu.user.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class);
        long pkColumnKey = columnInfo.emailColKey;
        String primaryKeyValue = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$email();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$password = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        }
        String realmGet$fullName = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$fullName();
        if (realmGet$fullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullNameColKey, objKey, realmGet$fullName, false);
        }
        String realmGet$phoneNumber = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        }
        String realmGet$birthPlace = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthPlace();
        if (realmGet$birthPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceColKey, objKey, realmGet$birthPlace, false);
        }
        String realmGet$birthDate = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthDate();
        if (realmGet$birthDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthDateColKey, objKey, realmGet$birthDate, false);
        }
        return objKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class);
        long pkColumnKey = columnInfo.emailColKey;
        com.example.myapplication.menu.user.User object = null;
        while (objects.hasNext()) {
            object = (com.example.myapplication.menu.user.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$email();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$password = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            }
            String realmGet$fullName = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$fullName();
            if (realmGet$fullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullNameColKey, objKey, realmGet$fullName, false);
            }
            String realmGet$phoneNumber = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            }
            String realmGet$birthPlace = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthPlace();
            if (realmGet$birthPlace != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceColKey, objKey, realmGet$birthPlace, false);
            }
            String realmGet$birthDate = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthDate();
            if (realmGet$birthDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthDateColKey, objKey, realmGet$birthDate, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.myapplication.menu.user.User object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class);
        long pkColumnKey = columnInfo.emailColKey;
        String primaryKeyValue = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$email();
        long objKey = Table.NO_MATCH;
        if (primaryKeyValue == null) {
            objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
        } else {
            objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
        }
        if (objKey == Table.NO_MATCH) {
            objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
        }
        cache.put(object, objKey);
        String realmGet$password = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$password();
        if (realmGet$password != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
        }
        String realmGet$fullName = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$fullName();
        if (realmGet$fullName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fullNameColKey, objKey, realmGet$fullName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fullNameColKey, objKey, false);
        }
        String realmGet$phoneNumber = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$phoneNumber();
        if (realmGet$phoneNumber != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
        }
        String realmGet$birthPlace = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthPlace();
        if (realmGet$birthPlace != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceColKey, objKey, realmGet$birthPlace, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthPlaceColKey, objKey, false);
        }
        String realmGet$birthDate = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthDate();
        if (realmGet$birthDate != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.birthDateColKey, objKey, realmGet$birthDate, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.birthDateColKey, objKey, false);
        }
        return objKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        long tableNativePtr = table.getNativePtr();
        UserColumnInfo columnInfo = (UserColumnInfo) realm.getSchema().getColumnInfo(com.example.myapplication.menu.user.User.class);
        long pkColumnKey = columnInfo.emailColKey;
        com.example.myapplication.menu.user.User object = null;
        while (objects.hasNext()) {
            object = (com.example.myapplication.menu.user.User) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            String primaryKeyValue = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$email();
            long objKey = Table.NO_MATCH;
            if (primaryKeyValue == null) {
                objKey = Table.nativeFindFirstNull(tableNativePtr, pkColumnKey);
            } else {
                objKey = Table.nativeFindFirstString(tableNativePtr, pkColumnKey, primaryKeyValue);
            }
            if (objKey == Table.NO_MATCH) {
                objKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, primaryKeyValue);
            }
            cache.put(object, objKey);
            String realmGet$password = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$password();
            if (realmGet$password != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.passwordColKey, objKey, realmGet$password, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.passwordColKey, objKey, false);
            }
            String realmGet$fullName = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$fullName();
            if (realmGet$fullName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fullNameColKey, objKey, realmGet$fullName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fullNameColKey, objKey, false);
            }
            String realmGet$phoneNumber = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$phoneNumber();
            if (realmGet$phoneNumber != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.phoneNumberColKey, objKey, realmGet$phoneNumber, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.phoneNumberColKey, objKey, false);
            }
            String realmGet$birthPlace = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthPlace();
            if (realmGet$birthPlace != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthPlaceColKey, objKey, realmGet$birthPlace, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthPlaceColKey, objKey, false);
            }
            String realmGet$birthDate = ((com_example_myapplication_menu_user_UserRealmProxyInterface) object).realmGet$birthDate();
            if (realmGet$birthDate != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.birthDateColKey, objKey, realmGet$birthDate, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.birthDateColKey, objKey, false);
            }
        }
    }

    public static com.example.myapplication.menu.user.User createDetachedCopy(com.example.myapplication.menu.user.User realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.myapplication.menu.user.User unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.myapplication.menu.user.User();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.myapplication.menu.user.User) cachedObject.object;
            }
            unmanagedObject = (com.example.myapplication.menu.user.User) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_myapplication_menu_user_UserRealmProxyInterface unmanagedCopy = (com_example_myapplication_menu_user_UserRealmProxyInterface) unmanagedObject;
        com_example_myapplication_menu_user_UserRealmProxyInterface realmSource = (com_example_myapplication_menu_user_UserRealmProxyInterface) realmObject;
        Realm objectRealm = (Realm) ((RealmObjectProxy) realmObject).realmGet$proxyState().getRealm$realm();
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$password(realmSource.realmGet$password());
        unmanagedCopy.realmSet$fullName(realmSource.realmGet$fullName());
        unmanagedCopy.realmSet$phoneNumber(realmSource.realmGet$phoneNumber());
        unmanagedCopy.realmSet$birthPlace(realmSource.realmGet$birthPlace());
        unmanagedCopy.realmSet$birthDate(realmSource.realmGet$birthDate());

        return unmanagedObject;
    }

    static com.example.myapplication.menu.user.User update(Realm realm, UserColumnInfo columnInfo, com.example.myapplication.menu.user.User realmObject, com.example.myapplication.menu.user.User newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        com_example_myapplication_menu_user_UserRealmProxyInterface realmObjectTarget = (com_example_myapplication_menu_user_UserRealmProxyInterface) realmObject;
        com_example_myapplication_menu_user_UserRealmProxyInterface realmObjectSource = (com_example_myapplication_menu_user_UserRealmProxyInterface) newObject;
        Table table = realm.getTable(com.example.myapplication.menu.user.User.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.emailColKey, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.passwordColKey, realmObjectSource.realmGet$password());
        builder.addString(columnInfo.fullNameColKey, realmObjectSource.realmGet$fullName());
        builder.addString(columnInfo.phoneNumberColKey, realmObjectSource.realmGet$phoneNumber());
        builder.addString(columnInfo.birthPlaceColKey, realmObjectSource.realmGet$birthPlace());
        builder.addString(columnInfo.birthDateColKey, realmObjectSource.realmGet$birthDate());

        builder.updateExistingTopLevelObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("User = proxy[");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{password:");
        stringBuilder.append(realmGet$password() != null ? realmGet$password() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fullName:");
        stringBuilder.append(realmGet$fullName() != null ? realmGet$fullName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{phoneNumber:");
        stringBuilder.append(realmGet$phoneNumber() != null ? realmGet$phoneNumber() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthPlace:");
        stringBuilder.append(realmGet$birthPlace() != null ? realmGet$birthPlace() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{birthDate:");
        stringBuilder.append(realmGet$birthDate() != null ? realmGet$birthDate() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long objKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (objKey ^ (objKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_myapplication_menu_user_UserRealmProxy aUser = (com_example_myapplication_menu_user_UserRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aUser.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aUser.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aUser.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
