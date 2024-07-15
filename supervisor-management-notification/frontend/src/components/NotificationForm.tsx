import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './NotificationForm.css'; // Make sure to create this CSS file

const NotificationForm: React.FC = () => {
  const [supervisors, setSupervisors] = useState<string[]>([]);
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    supervisor: ''
  });
  const [message, setMessage] = useState<string>('');

  useEffect(() => {
    const fetchSupervisors = async () => {
      try {
        const response = await axios.get<string[]>('/api/supervisors');
        setSupervisors(response.data);
      } catch (error) {
        console.error('Error fetching supervisors:', error);
      }
    };

    fetchSupervisors();
  }, []);

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e: React.FormEvent<HTMLFormElement>) => {
    e.preventDefault();
    try {
      const response = await axios.post<{ message: string }>('/api/submit', formData);
      setMessage(response.data.message);
      setFormData({
        firstName: '',
        lastName: '',
        email: '',
        phoneNumber: '',
        supervisor: ''
      });
    } catch (error: any) {
      setMessage(error.response.data.error);
    }
  };

  return (
    <div className="form-container">
      <h1>Notification Form</h1>
      <form onSubmit={handleSubmit}>
        <div className="form-row">
          <div className="form-group">
            <label>First Name</label>
            <input type="text" name="firstName" value={formData.firstName} onChange={handleChange} required />
          </div>
          <div className="form-group">
            <label>Last Name</label>
            <input type="text" name="lastName" value={formData.lastName} onChange={handleChange} required />
          </div>
        </div>
        <div className="form-group">
          <label className="questionLabel">How would you prefer to be notified?</label>
        </div>
        <div className="checkbox-row">
          <div className="checkbox-group">
            <label>
              <input type="checkbox" />
              Email
            </label>
            <input type="email" name="email" value={formData.email} onChange={handleChange} />
          </div>
          <div className="checkbox-group">
            <label>
              <input type="checkbox" />
              Phone Number
            </label>
            <input type="tel" name="phoneNumber" value={formData.phoneNumber} onChange={handleChange} />
          </div>
        </div>
        <div className="supervisor-group">
          <div className="form-group">
            <label>Supervisor</label>
            <select name="supervisor" value={formData.supervisor} onChange={handleChange} required>
              <option value="">Select...</option>
              {supervisors.map((supervisor, index) => (
                <option key={index} value={supervisor}>{supervisor}</option>
              ))}
            </select>
          </div>
        </div>
        <button type="submit">Submit</button>
      </form>
      {message && <p>{message}</p>}
    </div>
  );
};

export default NotificationForm;
