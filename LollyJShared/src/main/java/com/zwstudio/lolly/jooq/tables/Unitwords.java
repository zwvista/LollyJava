/**
 * This class is generated by jOOQ
 */
package com.zwstudio.lolly.jooq.tables;


import com.zwstudio.lolly.jooq.DefaultSchema;
import com.zwstudio.lolly.jooq.Keys;
import com.zwstudio.lolly.jooq.tables.records.UnitwordsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Unitwords extends TableImpl<UnitwordsRecord> {

    private static final long serialVersionUID = -1013681413;

    /**
     * The reference instance of <code>UNITWORDS</code>
     */
    public static final Unitwords UNITWORDS = new Unitwords();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UnitwordsRecord> getRecordType() {
        return UnitwordsRecord.class;
    }

    /**
     * The column <code>UNITWORDS.ID</code>.
     */
    public final TableField<UnitwordsRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.TEXTBOOKID</code>.
     */
    public final TableField<UnitwordsRecord, Integer> TEXTBOOKID = createField("TEXTBOOKID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.UNIT</code>.
     */
    public final TableField<UnitwordsRecord, Integer> UNIT = createField("UNIT", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.PART</code>.
     */
    public final TableField<UnitwordsRecord, Integer> PART = createField("PART", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.SEQNUM</code>.
     */
    public final TableField<UnitwordsRecord, Integer> SEQNUM = createField("SEQNUM", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.WORD</code>.
     */
    public final TableField<UnitwordsRecord, String> WORD = createField("WORD", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>UNITWORDS.NOTE</code>.
     */
    public final TableField<UnitwordsRecord, String> NOTE = createField("NOTE", org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * Create a <code>UNITWORDS</code> table reference
     */
    public Unitwords() {
        this("UNITWORDS", null);
    }

    /**
     * Create an aliased <code>UNITWORDS</code> table reference
     */
    public Unitwords(String alias) {
        this(alias, UNITWORDS);
    }

    private Unitwords(String alias, Table<UnitwordsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Unitwords(String alias, Table<UnitwordsRecord> aliased, Field<?>[] parameters) {
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
    public UniqueKey<UnitwordsRecord> getPrimaryKey() {
        return Keys.PK_UNITWORDS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<UnitwordsRecord>> getKeys() {
        return Arrays.<UniqueKey<UnitwordsRecord>>asList(Keys.PK_UNITWORDS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<UnitwordsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UnitwordsRecord, ?>>asList(Keys.FK_UNITWORDS_TEXTBOOKS_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Unitwords as(String alias) {
        return new Unitwords(alias, this);
    }

    /**
     * Rename this table
     */
    public Unitwords rename(String name) {
        return new Unitwords(name, null);
    }
}
