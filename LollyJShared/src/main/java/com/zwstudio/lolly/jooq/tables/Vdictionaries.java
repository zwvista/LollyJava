/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables;


import com.zwstudio.lolly.jooq.DefaultSchema;
import com.zwstudio.lolly.jooq.tables.records.VdictionariesRecord;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Vdictionaries extends TableImpl<VdictionariesRecord> {

    private static final long serialVersionUID = -496887060;

    /**
     * The reference instance of <code>VDICTIONARIES</code>
     */
    public static final Vdictionaries VDICTIONARIES = new Vdictionaries();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VdictionariesRecord> getRecordType() {
        return VdictionariesRecord.class;
    }

    /**
     * The column <code>VDICTIONARIES.ID</code>.
     */
    public final TableField<VdictionariesRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VDICTIONARIES.LANGIDFROM</code>.
     */
    public final TableField<VdictionariesRecord, Integer> LANGIDFROM = createField("LANGIDFROM", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VDICTIONARIES.LANGIDTO</code>.
     */
    public final TableField<VdictionariesRecord, Integer> LANGIDTO = createField("LANGIDTO", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VDICTIONARIES.SEQNUM</code>.
     */
    public final TableField<VdictionariesRecord, Integer> SEQNUM = createField("SEQNUM", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VDICTIONARIES.DICTTYPENAME</code>.
     */
    public final TableField<VdictionariesRecord, String> DICTTYPENAME = createField("DICTTYPENAME", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.DICTNAME</code>.
     */
    public final TableField<VdictionariesRecord, String> DICTNAME = createField("DICTNAME", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.URL</code>.
     */
    public final TableField<VdictionariesRecord, String> URL = createField("URL", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.CHCONV</code>.
     */
    public final TableField<VdictionariesRecord, String> CHCONV = createField("CHCONV", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.AUTOMATION</code>.
     */
    public final TableField<VdictionariesRecord, String> AUTOMATION = createField("AUTOMATION", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.AUTOJUMP</code>.
     */
    public final TableField<VdictionariesRecord, Object> AUTOJUMP = createField("AUTOJUMP", org.jooq.impl.DefaultDataType.getDefaultDataType("BOOL"), this, "");

    /**
     * The column <code>VDICTIONARIES.DICTTABLE</code>.
     */
    public final TableField<VdictionariesRecord, String> DICTTABLE = createField("DICTTABLE", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.TRANSFORM_WIN</code>.
     */
    public final TableField<VdictionariesRecord, String> TRANSFORM_WIN = createField("TRANSFORM_WIN", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.TRANSFORM_MAC</code>.
     */
    public final TableField<VdictionariesRecord, String> TRANSFORM_MAC = createField("TRANSFORM_MAC", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VDICTIONARIES.WAIT</code>.
     */
    public final TableField<VdictionariesRecord, Integer> WAIT = createField("WAIT", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VDICTIONARIES.TEMPLATE</code>.
     */
    public final TableField<VdictionariesRecord, String> TEMPLATE = createField("TEMPLATE", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>VDICTIONARIES</code> table reference
     */
    public Vdictionaries() {
        this("VDICTIONARIES", null);
    }

    /**
     * Create an aliased <code>VDICTIONARIES</code> table reference
     */
    public Vdictionaries(String alias) {
        this(alias, VDICTIONARIES);
    }

    private Vdictionaries(String alias, Table<VdictionariesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Vdictionaries(String alias, Table<VdictionariesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vdictionaries as(String alias) {
        return new Vdictionaries(alias, this);
    }

    /**
     * Rename this table
     */
    public Vdictionaries rename(String name) {
        return new Vdictionaries(name, null);
    }
}
