/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables;


import com.zwstudio.lolly.jooq.DefaultSchema;
import com.zwstudio.lolly.jooq.tables.records.VtextsitesRecord;

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
public class Vtextsites extends TableImpl<VtextsitesRecord> {

    private static final long serialVersionUID = 336413248;

    /**
     * The reference instance of <code>VTEXTSITES</code>
     */
    public static final Vtextsites VTEXTSITES = new Vtextsites();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<VtextsitesRecord> getRecordType() {
        return VtextsitesRecord.class;
    }

    /**
     * The column <code>VTEXTSITES.ID</code>.
     */
    public final TableField<VtextsitesRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>VTEXTSITES.TEXTSITENAME</code>.
     */
    public final TableField<VtextsitesRecord, String> TEXTSITENAME = createField("TEXTSITENAME", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.TRANSFORM_WIN</code>.
     */
    public final TableField<VtextsitesRecord, String> TRANSFORM_WIN = createField("TRANSFORM_WIN", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.TRANSFORM_MAC</code>.
     */
    public final TableField<VtextsitesRecord, String> TRANSFORM_MAC = createField("TRANSFORM_MAC", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.TEMPLATE</code>.
     */
    public final TableField<VtextsitesRecord, String> TEMPLATE = createField("TEMPLATE", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.URL</code>.
     */
    public final TableField<VtextsitesRecord, String> URL = createField("URL", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.USFOLDER</code>.
     */
    public final TableField<VtextsitesRecord, String> USFOLDER = createField("USFOLDER", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>VTEXTSITES.WAIT</code>.
     */
    public final TableField<VtextsitesRecord, Integer> WAIT = createField("WAIT", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>VTEXTSITES</code> table reference
     */
    public Vtextsites() {
        this("VTEXTSITES", null);
    }

    /**
     * Create an aliased <code>VTEXTSITES</code> table reference
     */
    public Vtextsites(String alias) {
        this(alias, VTEXTSITES);
    }

    private Vtextsites(String alias, Table<VtextsitesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Vtextsites(String alias, Table<VtextsitesRecord> aliased, Field<?>[] parameters) {
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
    public Vtextsites as(String alias) {
        return new Vtextsites(alias, this);
    }

    /**
     * Rename this table
     */
    public Vtextsites rename(String name) {
        return new Vtextsites(name, null);
    }
}
