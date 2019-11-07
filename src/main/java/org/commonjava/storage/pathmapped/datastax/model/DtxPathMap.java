package org.commonjava.storage.pathmapped.datastax.model;

import com.datastax.driver.mapping.annotations.ClusteringColumn;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.Table;
import org.commonjava.storage.pathmapped.model.PathMap;

import java.util.Date;
import java.util.Objects;

@Table( name = "pathmap", readConsistency = "QUORUM", writeConsistency = "QUORUM" )
public class DtxPathMap implements PathMap
{
    @PartitionKey(0)
    private String fileSystem;

    @PartitionKey(1)
    private String subSystem;

    @ClusteringColumn(0)
    private String parentPath;

    @ClusteringColumn(1)
    private String filename;

    @Column
    private String fileId;

    @Column
    private Date creation;

    @Column
    private long size;

    @Column
    private String fileStorage;

    @Column
    private String checksum;

    public DtxPathMap()
    {
    }

    public DtxPathMap( String fileSystem, String subSystem, String parentPath, String filename, String fileId, Date creation, long size, String fileStorage, String checksum )
    {
        this.fileSystem = fileSystem;
        this.subSystem = subSystem;
        this.parentPath = parentPath;
        this.filename = filename;
        this.fileId = fileId;
        this.creation = creation;
        this.size = size;
        this.fileStorage = fileStorage;
        this.checksum = checksum;
    }

    public String getFileId()
    {
        return fileId;
    }

    public void setFileId( String fileId )
    {
        this.fileId = fileId;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize( long size )
    {
        this.size = size;
    }

    public String getFileStorage()
    {
        return fileStorage;
    }

    public void setFileStorage( String fileStorage )
    {
        this.fileStorage = fileStorage;
    }

    public Date getCreation()
    {
        return creation;
    }

    public void setCreation( Date creation )
    {
        this.creation = creation;
    }

    public String getFileSystem()
    {
        return fileSystem;
    }

    public void setFileSystem( String fileSystem )
    {
        this.fileSystem = fileSystem;
    }

    public String getSubSystem()
    {
        return subSystem;
    }

    public void setSubSystem( String subSystem )
    {
        this.subSystem = subSystem;
    }

    public String getParentPath()
    {
        return parentPath;
    }

    public void setParentPath( String parentPath )
    {
        this.parentPath = parentPath;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename( String filename )
    {
        this.filename = filename;
    }

    @Override
    public String getChecksum()
    {
        return checksum;
    }

    public void setChecksum( String checksum )
    {
        this.checksum = checksum;
    }

    @Override
    public boolean equals( Object o )
    {
        if ( this == o )
            return true;
        if ( o == null || getClass() != o.getClass() )
            return false;
        DtxPathMap that = (DtxPathMap) o;
        return fileSystem.equals( that.fileSystem ) && parentPath.equals( that.parentPath ) && filename.equals(
                        that.filename );
    }

    @Override
    public int hashCode()
    {
        return Objects.hash( fileSystem, parentPath, filename );
    }

    @Override
    public String toString()
    {
        return "DtxPathMap{" + "fileSystem='" + fileSystem + '\'' + ", parentPath='" + parentPath + '\''
                        + ", filename='" + filename + '\'' + ", fileId='" + fileId + '\'' + ", creation=" + creation
                        + ", size=" + size + ", fileStorage='" + fileStorage + '\'' + '}';
    }
}
